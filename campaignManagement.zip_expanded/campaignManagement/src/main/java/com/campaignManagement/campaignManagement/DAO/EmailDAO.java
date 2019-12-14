package com.campaignManagement.campaignManagement.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.campaignManagement.campaignManagement.model.User;
import com.sendgrid.Email;

public class EmailDAO {
	public List<User> getEmailList(){
		List<User> userList = new ArrayList<>();
		try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
        // auto close connection
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:8080/Campaign", "postgres", "password")) {

            if (conn != null) {
                System.out.println("Connected to the database!");
                
                
                conn.setAutoCommit(false);
                System.out.println("Opened database successfully");

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM users;" );
                while ( rs.next() ) {
                	User user =new User();
                	user.setAge(rs.getInt("age"));
                	user.setCountry(rs.getString("country"));
                	user.setEmailId(rs.getString("Email"));
                	user.setGender(rs.getString("gender"));
                	user.setName(rs.getString("name"));
                	user.setState(rs.getString("state"));
                	userList.add(user);
                	//emailList.add(new Email(rs.getString("Email")));                   
                 }
                rs.close();
                stmt.close();
                conn.close();
                
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
	    return userList;
	}
}

