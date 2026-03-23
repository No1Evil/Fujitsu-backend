package global.fujitsu.api.model.dto.request.get;

import global.fujitsu.api.model.dto.request.base.GetRequest;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;

public record GetMeasurementRequest(@NonNull Long regionId, @Nullable Instant timestamp) implements GetRequest {
}
