package app.doa;
import app.JDBCConnection;
import app.model.UserDetailM;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
public class UserRegisterDaoImpl {
    private static Connection connection;

    public boolean saveUserDetailDB(String email,String fname, String password, String screen_name, String dob, String gender, String status, String location, String visible) {
        JDBCConnection jdbc = JDBCConnection.getConnection();
        boolean isInserted=false;
        try {
            connection=JDBCConnection.connection;
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            
            Date date1; 
            date1 = new SimpleDateFormat("yyyy-mm-dd").parse(dob); 
            SimpleDateFormat formatter = new SimpleDateFormat("DD-MMM-YY"); 
            String strDate= formatter.format(date1);
            // The Query
            String query = "INSERT INTO MEMBER VALUES"                                        + "\n" +
                        "('" + email+ "','" + password+ "','" + fname+ "','" + screen_name+ "','" +strDate + "','" + gender+ "','" + status+ "','" + location+ "','" + visible+ "')" ;
            System.out.println(query);
   
            // Get Result
            ResultSet results = statement.executeQuery(query);
            System.out.println(results);
   
            // Close the statement because we are done with it
            statement.close();
            isInserted=true;
            return isInserted;
         } catch (Exception e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
            return isInserted;
         }
    }
}
