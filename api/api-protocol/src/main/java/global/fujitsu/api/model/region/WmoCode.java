package global.fujitsu.api.model.region;

import lombok.NonNull;

public record WmoCode(@NonNull String value) {
    public WmoCode{
        if (value.isEmpty()){
            throw new IllegalArgumentException("WMO Code value cannot be empty");
        }
    }
}
