package global.fujitsu.persistence.dao.base;

import global.fujitsu.api.entity.model.fee.EntityFeeModel;
import global.fujitsu.api.model.dto.request.base.GetFeeRequest;
import global.fujitsu.api.model.fee.FeeResult;
import global.fujitsu.api.repository.base.FeeRepository;
import lombok.NonNull;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * BaseJdbcDao for EntityFee models and repositories provides protected method
 * {@code findBaseFee(String sql, Object... args)} to prevent DRY code for finding fees.
 * <p>
 * <b> Columns {@code fee} and {@code is_allowed} are included
 * </p>
 * @param <E> entity fee model
 * @param <G> get fee request
 */
public abstract class BaseJdbcFeeBasedDao<E extends EntityFeeModel, G extends GetFeeRequest>
    extends BaseJdbcDao<E>
    implements FeeRepository<E, G> {

  /**
   * @param columnNames columns {@code fee} and {@code is_allowed} are included
   */
  public BaseJdbcFeeBasedDao(@NonNull JdbcTemplate jdbcTemplate, @NonNull String tableName,
      @NonNull List<String> columnNames, @NonNull Class<E> entityClass) {
    List<String> mutableList = new ArrayList<>(columnNames);
    mutableList.add("fee");
    mutableList.add("is_allowed");
    super(jdbcTemplate, tableName, mutableList, entityClass);
  }

  protected Optional<FeeResult> findBaseFee(String sql, Object... args) {
    return jdbcTemplate.query(sql, mapper, args)
        .stream().findFirst().map(EntityFeeModel::toFeeResult);
  }
}
