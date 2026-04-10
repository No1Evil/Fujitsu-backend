package global.fujitsu.api.repository.fee;

import global.fujitsu.api.domain.model.fee.WeatherPhenomenonFeeEntity;
import global.fujitsu.api.model.weather.WeatherPhenomenon;
import global.fujitsu.api.repository.base.FeeRepository;

/** Repository for {@link WeatherPhenomenonFeeEntity} entities. */
public interface WeatherPhenomenonFeeRepository extends FeeRepository<
    WeatherPhenomenonFeeEntity,
    WeatherPhenomenon> {

}
