package app.doa;
import app.JDBCConnection;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;


/**
 * UserDeleteDaoImpl
 */
public class UserDeleteDaoImpl {
    private static Connection connection;
    public boolean updateUserDetailDB(String email) {
        JDBCConnection jdbc = JDBCConnection.getConnection();
        boolean isUpdated=false;
        try {
            connection=JDBCConnection.connection;
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
                // The Query
                String query = "DELETE FROM MEMBER" + "\n" +
                        "WHERE EMAILADDRESS = '" + email + "'" ;
            System.out.println(query);
   
            // Get Result
            ResultSet results = statement.executeQuery(query);
            System.out.println(results);

            // Close the statement because we are done with it
            statement.close();
            isUpdated=true;
            return isUpdated;
            
         } catch (Exception e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
            return isUpdated;
         }
    }
}