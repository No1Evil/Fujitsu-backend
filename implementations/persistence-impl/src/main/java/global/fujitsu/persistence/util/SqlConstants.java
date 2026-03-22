package global.fujitsu.persistence.util;

import lombok.NonNull;

import java.util.List;

public final class SqlConstants {
    public static String FIND_BY_ID_QUERY(String tableName){
        return FIND_BY_QUERY(tableName, "id");
    }

    public static String FIND_BY_NAME_QUERY(String tableName){
        return FIND_BY_QUERY(tableName, "name");
    }

    public static String FIND_BY_QUERY(String tableName, String columnName){
        return "select * from %s where %s = ?"
            .formatted(tableName.toLowerCase(), columnName.toLowerCase());
    }

    public static String FIND_ALL_QUERY(String tableName){
        return "select * from %s"
            .formatted(tableName.toLowerCase());
    }

    public static String DELETE_BY_ID_QUERY(String tableName){
        return "delete from %s where id = ?"
            .formatted(tableName.toLowerCase());
    }

    public static String INSERT_QUERY(@NonNull String tableName, @NonNull List<String> columnNames) {
        String columns = String.join(", ", columnNames);

        String valuesPlaceholders = String.join(", ", java.util.Collections.nCopies(columnNames.size(), "?"));

        return formatString(tableName, columns, valuesPlaceholders);
    }

    private static String formatString(Object... values) {
        if (values == null || values.length == 0) {
            return "insert into {} ({}) values ({})";
        }

        return "insert into {} ({}) values ({})".replace("{}", "%s").formatted(values);
    }
}
