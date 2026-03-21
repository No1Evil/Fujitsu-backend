package global.fujitsu.api.entity.region;

import lombok.NonNull;

public record RegionName(@NonNull String value) {
    public RegionName{
        if (value.isBlank()){
            throw new IllegalArgumentException("Region value cannot be empty");
        }
    }
}
