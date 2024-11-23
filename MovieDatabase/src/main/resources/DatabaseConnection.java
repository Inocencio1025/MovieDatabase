import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) {        // Database URL, username, and password
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";  // Replace with your database URL
        String username = "C##CSI3450";  // Your DB username
        String password = "Rj102593$";  // Your DB password

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            System.out.println("Connected to Oracle Database successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed!");
        }
    }
}
