package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    public Connection connection;

    public DBContext() {
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=travelprj";
            String username = "sa";
            String password = System.getenv("DB_PASSWORD"); // Read password from environment variable
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        try {
            // Uncovered code
            System.out.println(new DBContext().connection);
        } catch (Exception e) {
            // Handle exception
        }
    }
}
