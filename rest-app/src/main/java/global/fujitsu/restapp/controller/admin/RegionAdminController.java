package global.fujitsu.restapp.controller.admin;

import global.fujitsu.api.domain.service.RegionService;
import global.fujitsu.api.protocol.dto.request.create.CreateRegionRequest;
import global.fujitsu.api.protocol.dto.response.get.RegionResponse;
import global.fujitsu.restapp.mapper.impl.RegionMapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
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
@RequestMapping(value = "/admin/regions", headers = "X-API-VERSION=1")
@RequiredArgsConstructor
public final class RegionAdminController {

  private final RegionService service;
  private final RegionMapper mapper;

  /** {@return created region id} */
  @PostMapping
  @Operation(description = "Creates new region")
  public ResponseEntity<Long> createRegion(@Valid @RequestBody CreateRegionRequest req) {
    return ResponseEntity.ok(service.create(mapper.toEntity(req)));
  }

  /** {@return found region} */
  @GetMapping("/{id}")
  @Operation(description = "Finds region by id")
  public ResponseEntity<RegionResponse> findById(@PathVariable Long id) {
    return ResponseEntity.ok(mapper.toResponse(service.findById(id)));
  }

  /** {@return if region is deleted} */
  @DeleteMapping("/{id}")
  @Operation(description = "Deletes region by id")
  public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
    return ResponseEntity.ok(service.delete(id));
  }
}
