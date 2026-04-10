package global.fujitsu.restapp.controller.client;

import global.fujitsu.api.domain.service.VehicleTypeService;
import global.fujitsu.api.protocol.dto.response.get.VehicleTypeResponse;
import global.fujitsu.api.domain.model.vehicle.VehicleType;
import global.fujitsu.restapp.mapper.impl.VehicleTypeMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** Provides public endpoint to vehicle types. */
@RestController
@RequestMapping(value = "/public/vehicles", headers = "X-API-VERSION=1")
@RequiredArgsConstructor
public class VehicleTypeController {

  private final VehicleTypeService service;
  private final VehicleTypeMapper mapper;

  /** {@return found vehicle types} */
  @GetMapping
  public ResponseEntity<List<VehicleTypeResponse>> findAll() {
    return ResponseEntity.ok(service.findAll().stream().map(mapper::toResponse).toList());
  }

  /** {@return found vehicle type} */
  @GetMapping("/find")
  public ResponseEntity<VehicleTypeResponse> findByName(@RequestParam String type) {
    return ResponseEntity.ok(mapper.toResponse(service.findByName(new VehicleType(type))));
  }
}
