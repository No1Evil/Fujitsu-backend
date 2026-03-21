package global.fujitsu.api.entity.model.region;

import global.fujitsu.api.entity.model.EntityModel;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.region.WmoCode;
import lombok.NonNull;

public record RegionEntity(
    @NonNull Long id,
    @NonNull RegionName name,
    @NonNull WmoCode wmoCode
) implements EntityModel {
}
