package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    // CommandLineRunner bean to test the database connection
    @Bean
    public CommandLineRunner testDatabaseConnection(JdbcTemplate jdbcTemplate) {
        return args -> {
            try {
                // 测试数据库连接，执行一个简单的 SQL 查询
                Integer result = jdbcTemplate.queryForObject("SELECT count(*) from sys_dept", Integer.class);
                if (result != null) {
                    System.out.println(result);
                    System.out.println("Database connection test successful.");
                } else {
                    System.out.println("Database connection test failed - no results.");
                }
            } catch (Exception e) {
                System.out.println("Database connection test failed.");
                e.printStackTrace();
            }
        };
    }
}
