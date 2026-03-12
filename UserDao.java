package java_core_only;
import java.sql.*;

public class UserDao {

    static final String URL = "jdbc:mysql://localhost:3306/shopping_db";
    static final String USER = "root";
    static final String PASS = "Aksh@t311"; // apna password

    // ✅ INSERT
    static void insertUser(String name, String email, String password) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO users (name, email, password) VALUES (?, ?, ?)"
            );
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.executeUpdate();
            System.out.println("User inserted: " + name);
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ✅ READ
    static void getAllUsers() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getString("email"));
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        insertUser("Akshat", "akshat@gmail.com", "1234");
        insertUser("Rahul", "rahul@gmail.com", "5678");
        getAllUsers();
    }
}