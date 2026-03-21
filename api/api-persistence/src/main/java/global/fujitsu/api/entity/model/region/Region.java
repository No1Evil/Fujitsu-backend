package global.fujitsu.api.entity.model.region;

import global.fujitsu.api.entity.model.EntityModel;
import global.fujitsu.api.model.region.RegionName;
import lombok.NonNull;

public record Region(@NonNull RegionName name, @NonNull String wmoCode) implements EntityModel {
    public Region {
        if (wmoCode.isBlank()){
            throw new IllegalArgumentException("WMO code cannot be null");
        }
    }
}
