package app.doa;

// @authors Preet Choudhary & Viet Tran

import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserShowPostDaoImpl {

    private static Connection connection;

    // Show Member Posts Query
    public ArrayList<String> getPost(String emailAddress) {
        ArrayList<String> post = new ArrayList<String>();

        try {
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT *"           + "\n" + 
                           "FROM post_response" + "\n" + 
                           "WHERE EMAILADDRESS = '" + emailAddress + "'";
            System.out.println(query);

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                String memberPost = results.getString("body");
                post.add(memberPost);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just print the error
            System.err.println(e.getMessage());
        }

        return post;
    }

}
