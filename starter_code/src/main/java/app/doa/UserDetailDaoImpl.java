package app.doa;

import app.JDBCConnection;
import app.model.UserDetailM;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UserDetailDaoImpl {
    // public static void main(String[] args){
    //     UserDetailDaoImpl usd=new UserDetailDaoImpl();
    //     usd.getUserDetailDB("preetbhrh", "password");
    // }
    private static Connection connection;

    public UserDetailM getUserDetailDB(String userName, String passWord) {
        JDBCConnection jdbc = JDBCConnection.getConnection();

        try {
            connection=JDBCConnection.connection;
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            UserDetailM userDetailM = new UserDetailM();

            // The Query
            String query = "SELECT *"                                        + "\n" +
                        "FROM member"                                      + "\n" +
                        "WHERE EMAILADDRESS = '" + userName+ "' AND PASSWORD = '" + passWord+ "'" ;
            System.out.println(query);
   
            // Get Result
            ResultSet results = statement.executeQuery(query);
            System.out.println(results);
   
            // Process all of the results
            while (results.next()) {
               //String emailaddress = results.getString("emailaddress");
               userDetailM.setEmailAddress(results.getString("emailaddress"));
            //    userDetailM.setDob(results.getString("dob"));
               userDetailM.setFullName(results.getString("fullname"));
            //    userDetailM.setGender(results.getString("gender"));
            //    userDetailM.setLocation(results.getString("location"));
            //    userDetailM.setScreenName(results.getString("screenname"));
            //    userDetailM.setStatus(results.getString("status"));
            //    userDetailM.setVisibilityLevel(results.getString("visibility"));
               System.out.println(results.getString("emailaddress"));
            }
   
            // Close the statement because we are done with it
            statement.close();
            if(null!=userDetailM && userDetailM.getEmailAddress()!=null){
                return userDetailM;
            }
            else{
                return null;
            }
         } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
         }
         return null;
    }
}
