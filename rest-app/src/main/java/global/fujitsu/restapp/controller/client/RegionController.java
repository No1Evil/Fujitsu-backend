package global.fujitsu.restapp.controller.client;

import global.fujitsu.api.domain.service.RegionService;
import global.fujitsu.api.model.dto.response.get.RegionResponse;
import global.fujitsu.api.model.region.RegionName;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** Provides public endpoint to regions. */
@RestController
@RequestMapping(value = "/public/regions", headers = "X-API-VERSION=1")
@RequiredArgsConstructor
public class RegionController {

  private final RegionService service;

  /** {@return found region list} */
  @GetMapping
  public ResponseEntity<List<RegionResponse>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  /** {@return found region} */
  @GetMapping("/find")
  public ResponseEntity<RegionResponse> findByName(@RequestParam String name) {
    return ResponseEntity.ok(service.findByRegionName(new RegionName(name)));
  }
}
