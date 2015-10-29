//package db.migration;
//
//import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//
//public class V1__Create_default_tables implements SpringJdbcMigration {
//    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
//        jdbcTemplate.execute(
//            "CREATE TABLE IF NOT EXISTS users( " +
//                "id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT, " +
//                "username VARCHAR(45) NOT NULL, " +
//                "password VARCHAR(45) NOT NULL, " +
//                "enabled TINYINT(1) UNSIGNED NOT NULL DEFAULT 1, " +
//                "PRIMARY KEY (id), INDEX username_idx (username), " +
//                "INDEX enabled_id (enabled) " +
//            ") ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_general_ci"
//        );
//
//
//        jdbcTemplate.execute(
//            "CREATE TABLE IF NOT EXISTS user_roles ( " +
//                "user_role_id INT(11) NOT NULL AUTO_INCREMENT, " +
//                "username VARCHAR(45) NOT NULL, " +
//                "role VARCHAR(45) NOT NULL, " +
//                "PRIMARY KEY (user_role_id), " +
//                "UNIQUE KEY uni_username_role (role,username), " +
//                "KEY fk_username_idx (username), " +
//                "CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username)" +
//            ") ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_general_ci"
//        );
//    }
//}