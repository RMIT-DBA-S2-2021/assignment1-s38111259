package app.doa;
import app.JDBCConnection;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
public class UserPostDaoImpl {
    private static Connection connection;

    public boolean postUserDetailDB(String post_responseID,String body, String timestamp, String parent_post, String parent_response, String MEMBER_EMAILADDRESS, String POST_RESPONSE_POST_RESPONSEID) {
        JDBCConnection jdbc = JDBCConnection.getConnection();
        boolean isPosted=false;
        try {
            connection=JDBCConnection.connection;
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            // The Query
        
            String query = "INSERT INTO POST_RESPONSE VALUES"                                        + "\n" +
                        "('" + post_responseID+ "','" + body+ "',TO_TIMESTAMP('" + timestamp+ "', 'YYYY-MM-DD HH24:MI:SS.FF3')," + parent_post+ "," +parent_response + ",'" + MEMBER_EMAILADDRESS+ "'," + POST_RESPONSE_POST_RESPONSEID+")" ;
            System.out.println(query);
   
            // Get Result
            ResultSet results = statement.executeQuery(query);
            System.out.println(results);
   
            // Close the statement because we are done with it
            statement.close();
            isPosted=true;
            return isPosted;
         } catch (Exception e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
            return isPosted;
         }
    }
}
