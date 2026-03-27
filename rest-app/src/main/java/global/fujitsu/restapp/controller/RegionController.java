package global.fujitsu.restapp.controller;

import global.fujitsu.api.domain.service.RegionService;
import global.fujitsu.api.model.dto.request.create.CreateRegionRequest;
import global.fujitsu.api.model.dto.response.get.RegionResponse;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.region.WmoCode;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Provides API for regions.
 */
@RestController
@RequestMapping("api/v1/admin/regions")
@RequiredArgsConstructor
public class RegionController {

  private final RegionService regionService;

  /** {@return found region by name} */
  @GetMapping
  public ResponseEntity<RegionResponse> findByRegionName(
      @RequestBody RegionName regionName) {
    return ResponseEntity.ok(regionService.findByRegionName(regionName));
  }

  /** {@return found region by WMO code} */
  @GetMapping
  public ResponseEntity<RegionResponse> findByWmoCode(
      @RequestBody WmoCode wmoCode) {
    return ResponseEntity.ok(regionService.findByWmoCode(wmoCode));
  }

  /** {@return created region id} */
  @PostMapping
  public ResponseEntity<Long> createRegion(
      @RequestBody CreateRegionRequest req) {
    return ResponseEntity.ok(regionService.create(req));
  }

  /** {@return found region} */
  @PostMapping
  public ResponseEntity<RegionResponse> findById(
      @RequestParam Long id) {
    return ResponseEntity.ok(regionService.findById(id));
  }

  /** {@return if region is deleted} */
  @DeleteMapping
  public ResponseEntity<Boolean> deleteById(
      @RequestParam Long id) {
    return ResponseEntity.ok(regionService.delete(id));
  }

  /** {@return found region list} */
  @GetMapping
  public ResponseEntity<List<RegionResponse>> findAll() {
    return ResponseEntity.ok(regionService.findAll());
  }
}
