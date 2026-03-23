package global.fujitsu.persistence.converter;

import global.fujitsu.api.model.region.RegionName;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public final class StringToRegionNameConverter implements Converter<String, RegionName> {
    @Override
    public RegionName convert(@NonNull String source) {
        return new RegionName(source);
    }
}
