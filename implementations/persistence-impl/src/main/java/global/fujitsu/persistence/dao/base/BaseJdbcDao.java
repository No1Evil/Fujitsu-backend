package global.fujitsu.persistence.dao.base;

import global.fujitsu.api.entity.model.EntityModel;
import global.fujitsu.api.repository.base.Repository;
import global.fujitsu.persistence.util.SqlConstants;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Base Dao to provide default jdbc queries.
 *
 * @param <E> class implementing {@link EntityModel}
 */
@Slf4j
public abstract class BaseJdbcDao<E extends EntityModel> implements Repository<E> {

  protected final JdbcTemplate jdbcTemplate;
  protected final DataClassRowMapper<E> mapper;
  protected final String tableName;

  protected final String findByIdQuery;
  protected final String findAllQuery;
  protected final String deleteByIdQuery;
  protected final String insertQuery;

  /**
   * Sets up queries through {@code tableName}.
   *
   * @param jdbcTemplate jdbc template
   * @param tableName the name of the table
   * @param allColumnNames all column names without {@code id}
   * @param entityClass the Entity Model that being utilized
   */
  public BaseJdbcDao(
      @NonNull JdbcTemplate jdbcTemplate,
      @NonNull String tableName,
      @NonNull List<String> allColumnNames,
      @NonNull Class<E> entityClass
  ) {
    this.tableName = tableName;
    this.jdbcTemplate = jdbcTemplate;
    this.mapper = new DataClassRowMapper<>(entityClass);
    this.findByIdQuery = SqlConstants.FIND_BY_ID_QUERY(tableName);
    this.findAllQuery = SqlConstants.FIND_ALL_QUERY(tableName);
    this.deleteByIdQuery = SqlConstants.DELETE_BY_ID_QUERY(tableName);
    this.insertQuery = SqlConstants.INSERT_QUERY(tableName, allColumnNames);
  }

  @Override
  public Optional<E> findById(@NonNull Long id) {
    log.info("Executed 'Find by id {} query' for: {}", id, mapper.getMappedClass());
    return jdbcTemplate.query(findByIdQuery, mapper, id).stream().findFirst();
  }

  @Override
  public List<E> findAll() {
    log.info("Executed 'find all query' for: {}", mapper.getMappedClass());
    return jdbcTemplate.query(findAllQuery, mapper).stream().toList();
  }

  /** Loads SQL scripts into String format. */
  protected static String loadScript(Resource resource) throws IOException {
    log.debug("Executing loading script for {}", resource.getURL());
    return new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
  }

  /**
   * Set all fields of Entity on PreparedStatement for {@code INSERT_QUERY}.
   *
   * <p>Usage example:
   * <pre>
   *     {@code
   *     ps.setString(entity.string())
   *     ps.setLong(entity.long())
   *     return ps;
   *     }
   * </pre>
   * </p> Caution: The {@code primary key} of entity should be {@code id}
   */
  protected abstract PreparedStatement prepareSaveStatement(PreparedStatement ps, E entity)
      throws SQLException;

  @Override
  public Long save(E entity) {
    log.info("Executed 'Save entity {}' query for: {}", entity.toString(), mapper.getMappedClass());
    GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

    jdbcTemplate.update(con -> {
      var ps = con.prepareStatement(insertQuery, new String[] {"id"});
      return prepareSaveStatement(ps, entity);
    }, keyHolder);
    Number key = keyHolder.getKey();
    Objects.requireNonNull(key);
    return key.longValue();
  }

  @Override
  public boolean delete(@NonNull Long id) {
    log.info("Executed 'Delete entity by ID {}' query for: {}", id, mapper.getMappedClass());
    int rows = jdbcTemplate.update(deleteByIdQuery, mapper, id);
    return rows > 0;
  }
}
