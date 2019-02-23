package ru.vood.enumFromTable.repository.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.vood.enumFromTable.entity.Column;
import ru.vood.enumFromTable.entity.Index;
import ru.vood.enumFromTable.enums.DataType;
import ru.vood.enumFromTable.repository.TableInfoInterface;

import java.util.List;

@Service
public class TableInfoImpl implements TableInfoInterface {

    private final JdbcTemplate jdbcTemplate;

    public TableInfoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<String> getTables(String prefix) {
        return jdbcTemplate.query("select TABLE_NAME from all_tables at1 where at1.table_name like '" + prefix + "%'"
                , (rs, rowNum) -> rs.getString(1));
    }

    @Override
    public List<Column> getTableColumns(String tableName) {
        return jdbcTemplate.query("select col.table_name\n" +
                        "  , col.COLUMN_name\n" +
                        "  , col.DATA_TYPE\n" +
                        "from user_tab_columns col\n" +
                        "where col.table_name = '" + tableName + "'"
                , (rs, rowNum) -> Column.builder()
                        .tableName(rs.getString(1))
                        .columnName(rs.getString(2))
                        .dataType(DataType.getEnum(rs.getString(3)))
                        .build());
    }

    @Override
    public List<Index> getTablePKColumns(String tableName) {
        return jdbcTemplate.query("select\n" +
                        "  acc.table_name,\n" +
                        "  acc.column_name\n" +
                        "from all_constraints ac\n" +
                        "  , all_indexes ai\n" +
                        "  , all_cons_columns acc\n" +
                        "where ac.Table_name = '" + tableName + "'\n" +
                        "      and ac.constraint_type = 'P'\n" +
                        "      and ai.index_name = ac.index_name\n" +
                        "      and acc.constraint_name = ai.index_name\n"
                , (rs, rowNum) -> Index.builder()
                        .tableName(rs.getString(1))
                        .columnName(rs.getString(2))
                        .build());
    }

    @Override
    public List<Column> getTablesPKColumns(String prefix) {
        String sql = "select\n" +
                "  col.table_name,\n" +
                "  col.COLUMN_name,\n" +
                "  col.DATA_TYPE,\n" +
                "  case when acc.column_name is null\n" +
                "    then 0\n" +
                "  else 1 end case\n" +
                "from user_tab_columns col\n" +
                "  , (\n" +
                "      select\n" +
                "        acc.table_name  as table_name,\n" +
                "        acc.column_name as column_name\n" +
                "      from all_constraints ac\n" +
                "        , all_indexes ai\n" +
                "        , all_cons_columns acc\n" +
                "      where ac.constraint_type = 'P'\n" +
                "            and ai.index_name = ac.index_name\n" +
                "            and acc.constraint_name = ai.index_name\n" +
                "\n" +
                "    ) acc\n" +
                "where col.table_name like '" + prefix + "%'\n" +
                "      and col.table_name = acc.table_name (+)\n" +
                "      and col.COLUMN_name = acc.column_name (+)\n";
        return jdbcTemplate.query(sql
                , (rs, rowNum) -> Column.builder()
                        .tableName(rs.getString(1))
                        .columnName(rs.getString(2))
                        .dataType(DataType.getEnum(rs.getString(3)))
                        .isPKColumn(rs.getInt(4) == 1)
                        .build());
    }
}
