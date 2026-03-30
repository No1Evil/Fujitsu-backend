package global.fujitsu.restapp.controller.client;

import global.fujitsu.api.domain.service.VehicleTypeService;
import global.fujitsu.api.model.dto.response.get.VehicleTypeResponse;
import global.fujitsu.api.model.vehicle.VehicleType;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** Provides public endpoint to vehicle types. */
@RestController
@RequestMapping(value = "/public/vehicles", headers = "X-API-VERSION=1")
@RequiredArgsConstructor
public class VehicleTypeController {

  private final VehicleTypeService service;

  /** {@return found vehicle types} */
  @GetMapping
  public ResponseEntity<List<VehicleTypeResponse>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  /** {@return found vehicle type} */
  @GetMapping("/find")
  public ResponseEntity<VehicleTypeResponse> findByName(@RequestParam String type) {
    return ResponseEntity.ok(service.findByName(new VehicleType(type)));
  }
}
