package db.migration;

import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;


public class V1__Create_default_tables implements SpringJdbcMigration {

    private JdbcTemplate jdbcTemplate;

    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
        this.jdbcTemplate = jdbcTemplate;

        createVirtualDomains();
        createVirtualUsers();
        createVirtualAlises();
    }


    private void createVirtualDomains() {
        jdbcTemplate.execute(
            "CREATE TABLE `virtual_domains` (\n" +
            "  `id` int(11) NOT NULL auto_increment,\n" +
            "  `name` varchar(50) NOT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE KEY `name` (`name`),\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;"
        );
    }


    private void createVirtualUsers() {
        jdbcTemplate.execute(
            "CREATE TABLE `virtual_users` (\n" +
            "  `id` int(11) NOT NULL auto_increment,\n" +
            "  `domain_id` int(11) NOT NULL,\n" +
            "  `email` varchar(100) NOT NULL,\n" +
            "  `password` varchar(106) NOT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE KEY `email` (`email`),\n" +
            "  FOREIGN KEY (domain_id) REFERENCES virtual_domains(id) ON DELETE CASCADE\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;"
        );
    }


    private void createVirtualAlises() {
        jdbcTemplate.execute(
            "CREATE TABLE `virtual_aliases` (\n" +
            "  `id` int(11) NOT NULL auto_increment,\n" +
            "  `domain_id` int(11) NOT NULL,\n" +
            "  `source` varchar(100) NOT NULL,\n" +
            "  `destination` varchar(100) NOT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  FOREIGN KEY (domain_id) REFERENCES virtual_domains(id) ON DELETE CASCADE\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;"
        );
    }

}
