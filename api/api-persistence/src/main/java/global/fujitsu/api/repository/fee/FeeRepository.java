package global.fujitsu.api.repository.fee;

import global.fujitsu.api.entity.model.fee.EntityFeeModel;
import global.fujitsu.api.repository.Repository;

public sealed interface FeeRepository<E extends EntityFeeModel>
    extends Repository<E>
    permits AirTemperatureFeeRepository, RegionalBaseFeeRepository, WeatherPhenomenonFeeRepository, WindSpeedFeeRepository {
}
