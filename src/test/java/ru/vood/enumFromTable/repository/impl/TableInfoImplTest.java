package ru.vood.enumFromTable.repository.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.vood.enumFromTable.MainConfiguration;
import ru.vood.enumFromTable.entity.Column;
import ru.vood.enumFromTable.entity.Index;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainConfiguration.class)
@ActiveProfiles("application.yml")
public class TableInfoImplTest {

    private static final Logger log = LoggerFactory.getLogger(TableInfoImplTest.class);
    private final String v_bd_table = "V_BD_TABLE";
    @Autowired
    TableInfoImpl tableInfo;

    @Test
    public void getTables() {
        List<String> v_bd_t = tableInfo.getTables("V_BD_T");
        assertThat(v_bd_t, contains(v_bd_table));
    }

    @Test
    public void getTableColumns() {
        List<Column> tableColumns = tableInfo.getTableColumns(v_bd_table);
        assertThat(tableColumns.size(), greaterThan(0));
    }

    @Test
    public void getTablePKColumns() {
        log.info("1");
        List<Index> tablePKColumns = tableInfo.getTablePKColumns(v_bd_table);
        log.info("2");
        assertThat(tablePKColumns.size(), greaterThan(0));
    }
}