package java_core_only;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/shopping_db";
        String username = "root";
        String password = "Aksh@t311";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("✅ Database connected successfully!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("❌ Connection failed: " + e.getMessage());
        }
    }
}