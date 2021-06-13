package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import beans.User;

@Stateless
public class UserDataService implements UserAccessInterface {

	@Override
	public List<User> findAll() {
		String url = "jdbc:mysql://localhost:3306/userinfo";
		String username = "root";
		String password = "8160Prest!";
		Connection conn = null;
		List<User> userList = new ArrayList<User>(); 
	
		try
		{
			System.out.println("Entering Database");
			conn = DriverManager.getConnection(url, username, password );
			
			if (conn != null) {System.out.println("Connection Success");} else {System.out.println("Connection failure!!");}
			String query = "SELECT * FROM UserInfo.Users";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
		    while(result.next()) {
		    	  User users = new User();;
		    	  users.setUserId(result.getInt("ID"));
		    	  users.setFirstName(result.getString("FIRST_NAME"));
		          users.setLastName(result.getString("LAST_NAME"));
		          users.setMonth(result.getInt("BMONTH"));
		          users.setDay(result.getInt("BDAY"));
		          users.setYear(result.getInt("BYEAR"));
		          users.setEmailAddress(result.getString("EMAIL"));
		          users.setPassword(result.getString("UPASSWORD"));
		          userList.add(users);
		       }
		    result.close();
		    statement.close();conn.close();
		}
		catch (SQLException e)
		{
			System.out.println("failure!!");
		}
		return userList;
	}

	@Override
	public User findSelect(String email) {
		
		
		String url = "jdbc:mysql://localhost:3306/userinfo";
		String username = "root";
		String password = "8160Prest!";
		Connection conn = null;
		User found= new User();
		found.setUserId(-1);
		try
		{
			System.out.println("Entering Database");
			conn = DriverManager.getConnection(url, username, password );
			String query = "SELECT ID, FIRST_NAME, LAST_NAME, BMONTH, BDAY, BYEAR, EMAIL, UPASSWORD FROM UserInfo.Users WHERE EMAIL = " + "'" + email + "'";
					if (conn != null) {System.out.println("Connection Success");} else {System.out.println("Connection failure!!");}
				Statement stmt = conn.createStatement();
				ResultSet result=stmt.executeQuery(query);
			    
			    while (result.next()) {
					found.setUserId(result.getInt("ID"));
					found.setFirstName(result.getString("FIRST_NAME"));
			        found.setLastName(result.getString("LAST_NAME"));
			        found.setMonth(result.getInt("BMONTH"));
			        found.setDay(result.getInt("BDAY"));
			        found.setYear(result.getInt("BYEAR"));
			        found.setEmailAddress(result.getString("EMAIL"));
			        found.setPassword(result.getString("UPASSWORD"));
			    }
	         
			conn.close();
		}
		catch (SQLException e)
		{
			System.out.println("failure!!");
		}
		    

		return found;
	}
	@Override
	public void insert(User user) {
		String url = "jdbc:mysql://localhost:3306/userinfo";
		String username = "root";
		String password = "8160Prest!";
		Connection conn = null;
		String update = "INSERT INTO  UserInfo.Users (FIRST_NAME, LAST_NAME, BMONTH, BDAY, BYEAR, EMAIL, UPASSWORD) VALUES (?,?,?,?,?,?,?)";
		int userId = 0;
		ResultSet rs = null;
		try
		{
			conn = DriverManager.getConnection(url, username, password );
			if (conn != null) {System.out.println("Connection Success");} else {System.out.println("Connection failure!!");}
			PreparedStatement pstmt = conn.prepareStatement(update, Statement.RETURN_GENERATED_KEYS); 
			{
			
				pstmt.setString(1, user.getFirstName());
				pstmt.setString(2, user.getLastName());
				pstmt.setInt(3, user.getMonth());
				pstmt.setInt(4, user.getDay());
				pstmt.setInt(5, user.getYear());
				pstmt.setString(6, user.getEmailAddress());
				pstmt.setString(7, user.getPassword());
			
				int rowAffected = pstmt.executeUpdate();
				if(rowAffected == 1) 
				{
	                rs = pstmt.getGeneratedKeys();
	                if(rs.next())
	                    { userId = rs.getInt(1); }
				}
			}
		}
		catch (SQLException e)
		{
			System.out.println("failure!!");
		}
		finally 
		{
            try {
                	if(rs != null)  rs.close();
                } 
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
		}
	}

	@Override
	public void delete(String condition, String value) {
		String url = "jdbc:mysql://localhost:3306/userinfo";
		String username = "root";
		String password = "8160Prest!";
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(url, username, password );
			if (conn != null) {System.out.println("Connection Success");} else {System.out.println("Connection failure!!");}
			String queryColumn = "DELETE FROM  UserInfo.Users WHERE ";
			String queryWhere = "";
			String query = queryColumn + queryWhere;
			
			Statement statement = conn.createStatement();
			statement.executeUpdate(query);

		    statement.close();conn.close();
		}
		catch (SQLException e)
		{
			System.out.println("failure!!");
		}			
	}

}
