package daos;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static final String URL = "jdbc:mysql://localhost:3306/car";
    public static final String USER = "whitney";
    public static final String PASS = "password";

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    // /**
    // * Test Connection
    // */
    // public static void main(String[] args) {
    // Connection connection = ConnectionFactory.getConnection();
    // System.out.println("done");
    // }
}
