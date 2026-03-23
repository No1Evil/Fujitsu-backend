package global.fujitsu.api.domain.service;


import global.fujitsu.api.domain.service.base.BaseService;
import global.fujitsu.api.model.dto.request.create.CreateMeasurementRequest;
import global.fujitsu.api.model.dto.request.get.GetMeasurementRequest;
import global.fujitsu.api.model.dto.response.get.MeasurementResponse;

public interface MeasurementService extends BaseService<MeasurementResponse, CreateMeasurementRequest> {
    MeasurementResponse find(GetMeasurementRequest request);
}
