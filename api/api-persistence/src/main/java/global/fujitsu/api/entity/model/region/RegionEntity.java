package global.fujitsu.api.entity.model.region;

import global.fujitsu.api.entity.model.EntityModel;
import global.fujitsu.api.model.region.RegionName;
import global.fujitsu.api.model.region.WmoCode;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Provides region entity.
 *
 * @param id entity id.
 * @param name region name
 * @param wmoCode WMO code
 */
public record RegionEntity(
    @Nullable Long id,
    @NonNull RegionName name,
    @NonNull WmoCode wmoCode)
    implements EntityModel {

}
