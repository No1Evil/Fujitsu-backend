package global.fujitsu.persistence.converter;

import global.fujitsu.api.model.region.WmoCode;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public final class StringToWmoCodeConverter implements Converter<String, WmoCode> {
    @Override
    public WmoCode convert(@NonNull String source) {
        return new WmoCode(source);
    }
}
