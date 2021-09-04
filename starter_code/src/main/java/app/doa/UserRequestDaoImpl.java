package app.doa;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserRequestDaoImpl {
    private static Connection connection;

    // Display Friend Requests Query
    public ArrayList<String> getFriendRequest() {
        ArrayList<String> friendRequests = new ArrayList<String>();

        try {
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT *" + "\n" + 
                           "FROM friend_request";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                String friendRequestName = results.getString("sentBy");

                friendRequests.add(friendRequestName);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just print the error
            System.err.println(e.getMessage());
        }

        return friendRequests;
    }

}
