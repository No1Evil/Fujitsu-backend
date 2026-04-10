package global.fujitsu.restapp.domain.service;

import global.fujitsu.api.domain.model.measurement.MeasurementEntity;
import global.fujitsu.api.domain.service.MeasurementService;
import global.fujitsu.api.domain.service.RegionService;
import global.fujitsu.restapp.domain.parser.MeasurementParser;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Synchronizes the measurements with
 * <a href="https://www.ilmateenistus.ee">ilmateenistus</a>.
 */
@Slf4j
@Service
@RequiredArgsConstructor
@EnableScheduling
public class MeasurementSyncService {

  private final RegionService regionService;
  private final MeasurementService measurementService;
  private final MeasurementParser measurementParser;
  private final RestTemplate restTemplate = new RestTemplate();

  private final Map<String, Long> regionMap = new ConcurrentHashMap<>();

  /** Synchronizes measurements in the database. */
  @Scheduled(cron = "${env.WEATHER_SYNC_CRON_SCHEDULE}")
  public void sync() {
    log.info("started synchronizing");
    String url = "https://www.ilmateenistus.ee/ilma_andmed/xml/observations.php";

    // Checking regions if new ones were added or deleted
    refreshRegions();
    // Fetching xml and parsing
    if (!regionMap.isEmpty()) {
      restTemplate.execute(url, HttpMethod.GET, null, response -> {
        ArrayList<MeasurementEntity> requests = null;
        try {
          requests = measurementParser.parse(response.getBody(), regionMap);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
        requests.forEach(measurementService::create);
        return null;
      });
    } else {
      log.debug("No sync as region map is empty");
    }
  }

  /**
   * Refresh region map and insert all.
   */
  private void refreshRegions() {
    regionMap.clear();

    for (var region : regionService.findAll()) {
      String regionName = region.name().value();
      regionMap.put(regionName, region.id());
      log.debug("Inserted region {} with id{}", regionName, region.id());
    }
  }
}
