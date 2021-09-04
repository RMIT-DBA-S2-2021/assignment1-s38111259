package app.doa;

import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserSearchDaoImpl {
    private static Connection connection;

    // Search Member Query
    public ArrayList<String> getMember(String fullName) {
        ArrayList<String> member = new ArrayList<String>();

        try {
            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT *" + "\n" + 
                           "FROM member" + "\n" + 
                           "WHERE FULLNAME = '" + fullName + "'";
            System.out.println(query);

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                String memberFullName = results.getString("fullname");
                member.add(memberFullName);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just print the error
            System.err.println(e.getMessage());
        }

        return member;
    }

}
