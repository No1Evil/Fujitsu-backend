package global.fujitsu.restapp.controller.admin;

import global.fujitsu.api.domain.service.RegionService;
import global.fujitsu.api.model.dto.request.create.CreateRegionRequest;
import global.fujitsu.api.model.dto.response.get.RegionResponse;
import global.fujitsu.api.model.region.RegionName;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Provides API for regions.
 */
@RestController
@RequestMapping(value = "/api/admin/regions", headers = "X-API-VERSION=1")
@RequiredArgsConstructor
public final class RegionController {

  private final RegionService service;

  /**
   * Example: GET /api/v1/admin/regions?name=London.
   * GET /api/v1/admin/regions?code=123231.
   *
   * @return all regions or by name or by code
   */
  @GetMapping
  @Operation(description = "Finds by region name or all")
  public ResponseEntity<?> find(
      @RequestBody(required = false) RegionName name) {
    if (name != null) {
      return ResponseEntity.ok(service.findByRegionName(name));
    }
    return ResponseEntity.ok(service.findAll());
  }

  /** {@return created region id} */
  @PostMapping
  public ResponseEntity<Long> createRegion(@RequestBody CreateRegionRequest req) {
    return ResponseEntity.ok(service.create(req));
  }

  /** {@return found region} */
  @GetMapping("/{id}")
  public ResponseEntity<RegionResponse> findById(@PathVariable Long id) {
    return ResponseEntity.ok(service.findById(id));
  }

  /** {@return if region is deleted} */
  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
    return ResponseEntity.ok(service.delete(id));
  }
}
