package db.migration;

import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;


public class V1__Create_default_tables implements SpringJdbcMigration {
    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
        jdbcTemplate.execute(
            "CREATE TABLE IF NOT EXISTS users ( " +
                "username VARCHAR(45) NOT NULL , " +
                "password VARCHAR(45) NOT NULL , " +
                "enabled TINYINT NOT NULL DEFAULT 1 , " +
                "PRIMARY KEY (username) )"
        );
    }
}