package ru.vood.enumFromTable.run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainRunnable {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MainRunnable(@Qualifier("jdbcTemplateMy") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void run(String prefTable) {
        System.out.println("================jdbcTemplate ->" + jdbcTemplate);
        jdbcTemplate.execute("select * from dual");
        List<String> query = jdbcTemplate.query("select * from all_tables at1 where at1.table_name like '" + prefTable + "%", (rs, rowNum) -> rs.getString(1));
        System.out.println("================query ->" + query.size());
    }

}
