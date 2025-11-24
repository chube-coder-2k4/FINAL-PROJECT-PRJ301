package mylib;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Database Utility class for managing database connections
 *
 * @author Huy
 */
public class DBUtils {

    private static final Logger LOGGER = Logger.getLogger(DBUtils.class.getName());
    private static final String PROPERTIES_FILE = "mylib/DatabaseConfig.properties";
    private static final Properties properties;

    // Load properties on class initialization
    static {
        properties = new Properties();
        try (InputStream input = DBUtils.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                LOGGER.log(Level.SEVERE, "Unable to find database configuration file: {0}", PROPERTIES_FILE);
            } else {
                properties.load(input);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error loading database configuration", e);
        }
    }

    /**
     * Establishes a connection to the database
     *
     * @return Connection object or null if connection fails
     * @throws ClassNotFoundException if SQL Server JDBC driver is not found
     * @throws SQLException if database connection error occurs
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String dbName = properties.getProperty("db.name", "Car_Dealership");
        String userName = properties.getProperty("db.username", "sa");
        String password = properties.getProperty("db.password", "12345");
        String host = properties.getProperty("db.host", "localhost");
        String port = properties.getProperty("db.port", "1433");

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = String.format(
            "jdbc:sqlserver://%s:%s;databaseName=%s;encrypt=true;trustServerCertificate=true",
            host, port, dbName
        );

        LOGGER.log(Level.INFO, "Attempting to connect to database: {0}", dbName);
        return DriverManager.getConnection(url, userName, password);
    }
}
