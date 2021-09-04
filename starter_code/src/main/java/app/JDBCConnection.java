package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class for Managing the JDBC Connection to a SQLLite Database. Allows SQL
 * queries to be used with the SQLLite Databse in Java.
 * 
 * This is an example JDBC Connection that has a single query for the Movies
 * Database This is similar to the project workshop JDBC examples.
 *
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 * @author Halil Ali, 2021. email halil.ali@rmit.edu.au
 */
public class JDBCConnection {

   // the default oracle account uses the the read only MOVIES database
   // once you create a set of tables in your own account, update this to your RMIT
   // Oracle account details
   private static final String DATABASE_USERNAME = "s3811259";
   private static final String DATABASE_PASSWORD =  "Oracle@45";

   private static final String DATABASE_URL = "jdbc:oracle:thin:@//localhost:9922/CSAMPR1.its.rmit.edu.au";
   private static JDBCConnection jdbc = null;
   public static Connection connection;

   /**
    * Singleton function to return single copy of this class to other classes
    **/
   public static JDBCConnection getConnection() {

      // check that ssh session is still open (if not reopen)
      SSHTunnel.getSession();

      // check that JDBCconnection is available (if not establish)
      if (jdbc == null) {
         jdbc = new JDBCConnection();
      }
      return jdbc;
   }

   /**
    * Hidden constructor to establish Database connection (once)
    **/
   private JDBCConnection() {
      System.out.println("Created JDBC Connection Object");

      try {
         // Connect to JDBC data base
         connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
      } catch (SQLException e) {
         // If there is an error, lets just print the error
         System.err.println(e.getMessage());
      }
   }

   /**
    * Closes the database connection - called only when server shutdown
    **/
   public static void closeConnection() {
      try {
         if (connection != null) {
            connection.close();
            System.out.println("Database Connection closed");
         }
      } catch (SQLException e) {
         // connection close failed.
         System.err.println(e.getMessage());
      }
   }
}


