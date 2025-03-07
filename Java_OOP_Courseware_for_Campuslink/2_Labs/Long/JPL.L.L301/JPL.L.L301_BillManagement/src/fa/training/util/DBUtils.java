/**
 * @project JdbcLab
 */

package fa.training.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * author Duy Bach.
 * 
 * @time 12:25:29 PM
 * @date Jun 16, 2019
 */
public class DBUtils {

  private static DBUtils instance;
  private Connection connection;

  private DBUtils() {
    Properties properties = new Properties();

    try {
      properties.load(
          DBUtils.class.getResourceAsStream("/dbCOnfig.properties"));

      String driver = properties.getProperty("driver");
      String url = properties.getProperty("url");
      String userName = properties.getProperty("userName");
      String password = properties.getProperty("password");

      Class.forName(driver);

      connection = DriverManager.getConnection(url, userName, password);

    } catch (ClassNotFoundException | SQLException | IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Get the connection from the instance
   * 
   * @return {@link Connection}
   */
  public Connection getConnection() {
    return connection;
  }

  /**
   * Create new instance which connects with the database.
   * 
   * @return DatabaseConnection
   * @throws SQLException if connection false.
   */
  public static DBUtils getInstance() throws SQLException {
    if (instance == null || instance.getConnection().isClosed()) {
      instance = new DBUtils();
    }
    return instance;
  }
}
