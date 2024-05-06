import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestDataBase {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        // 测试数据库连接
        try {
            String sql = "SELECT * FROM sys_dept";
            jdbcTemplate.queryForObject(sql, Integer.class);
            System.out.println("Database connection test successful.");
        } catch (Exception e) {
            System.out.println("Database connection test failed.");
            e.printStackTrace();
        }
    }
}
