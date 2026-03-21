package global.fujitsu.api.entity.model.region;

import global.fujitsu.api.entity.model.EntityModel;
import global.fujitsu.api.model.region.RegionName;
import lombok.NonNull;

public record RegionEntity(
    @NonNull Long id,
    @NonNull RegionName name,
    @NonNull String wmoCode
) implements EntityModel {
    public RegionEntity {
        if (wmoCode.isBlank()){
            throw new IllegalArgumentException("WMO code cannot be null");
        }
    }
}
