package global.fujitsu.persistence.dao;

import global.fujitsu.api.entity.model.EntityModel;
import global.fujitsu.api.repository.Repository;
import global.fujitsu.persistence.util.SqlConstants;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
public abstract class BaseJdbcDao<E extends EntityModel> implements Repository<E> {
    protected final JdbcTemplate jdbcTemplate;
    protected final DataClassRowMapper<E> mapper;
    protected final String tableName;

    protected final String FIND_BY_ID_QUERY;
    protected final String FIND_ALL_QUERY;
    protected final String DELETE_BY_ID_QUERY;
    protected final String INSERT_QUERY;

    public BaseJdbcDao(
        @NonNull JdbcTemplate jdbcTemplate,
        @NonNull String tableName,
        @NonNull List<String> allColumnNames,
        @NonNull Class<E> entityClass
    ){
        this.tableName = tableName;
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = new DataClassRowMapper<>(entityClass);
        this.FIND_BY_ID_QUERY = SqlConstants.FIND_BY_ID_QUERY(tableName);
        this.FIND_ALL_QUERY = SqlConstants.FIND_ALL_QUERY(tableName);
        this.DELETE_BY_ID_QUERY =  SqlConstants.DELETE_BY_ID_QUERY(tableName);
        this.INSERT_QUERY = SqlConstants.INSERT_QUERY(tableName, allColumnNames);
    }

    public Optional<E> findById(@NonNull Long id) {
        log.info("Executed 'Find by id {} query' for: {}", id, mapper.getMappedClass());
        return jdbcTemplate.query(FIND_BY_ID_QUERY, mapper, id).stream().findFirst();
    }

    public List<E> findAll() {
        log.info("Executed 'find all query' for: {}", mapper.getMappedClass());
        return jdbcTemplate.query(FIND_ALL_QUERY, mapper).stream().toList();
    }

    protected static String loadScript(Resource resource) throws IOException {
        log.debug("Executing loading script for {}", resource.getURI());
        return new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }

    /**
     * Set all fields of Entity on PreparedStatement for {@code INSERT_QUERY}
     * <p>
     * Usage example:
     * <pre>
     *     {@code
     *     ps.setString(entity.string())
     *     ps.setLong(entity.long())
     *     return ps;
     *     }
     * </pre>
     * Caution: The {@code primary key} of entity should be {@code id}
     */
    protected abstract PreparedStatement prepareSaveStatement(PreparedStatement ps, E entity) throws SQLException;

    @Override
    public Long save(E entity) {
        log.info("Executed 'Save entity {}' query for: {}", entity.toString(), mapper.getMappedClass());
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            var ps = con.prepareStatement(INSERT_QUERY, new String[] {"id"});
            return prepareSaveStatement(ps, entity);
        }, keyHolder);
        Number key = keyHolder.getKey();
        Objects.requireNonNull(key);
        return key.longValue();
    }

    public boolean delete(@NonNull Long id) {
        log.info("Executed 'Delete entity by ID {}' query for: {}", id, mapper.getMappedClass());
        int rows = jdbcTemplate.update(DELETE_BY_ID_QUERY, mapper, id);
        return rows > 0;
    }
}
