package mylib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    private static final String DB_NAME = "Car_Dealership";
    private static final String USER_NAME = "sa";
    private static final String PASSWORD = "12345";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=" + DB_NAME + ";encrypt=true;trustServerCertificate=true";
        conn = DriverManager.getConnection(url, USER_NAME, PASSWORD);
        return conn;
    }
}
