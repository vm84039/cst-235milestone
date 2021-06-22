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
import beans.Movies;

@Stateless
public class MovieDataService implements MovieAccessInterface {

	@Override
	public List<Movies> findAll() {
		String url = "jdbc:mysql://localhost:3306/movieinfo";
		String username = "root";
		String password = "8160Prest!";
		Connection conn = null;
		List<Movies> movieList = new ArrayList<Movies>(); 
	
		try
		{
			System.out.println("Entering Database");
			conn = DriverManager.getConnection(url, username, password );
			
			if (conn != null) {System.out.println("Connection Success");} else {System.out.println("Connection failure!!");}
			String query = "SELECT * FROM MovieInfo.Movies";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
		    while(result.next()) {
		    	  Movies movies = new Movies();;
		    	  movies.setMovieID(result.getInt("ID"));
		    	  movies.setTitle(result.getString("Title"));
		          movies.setYear(result.getInt("RYEAR"));
		          movies.setGenre(result.getString("GENRE"));
		          movies.setLead(result.getString("STAR"));
		          movies.setStudio(result.getString("STUDIO"));
		          movies.setDirector(result.getString("DIRECTOR"));
		          movies.setLength(result.getInt("LENGTH"));
		          movies.setRental(result.getFloat("RENTAL"));
		          movies.setCost(result.getString("COST"));
		          movies.setRevenue(result.getString("REVENUE"));
		          movieList.add(movies);
		       }
		    result.close();
		    statement.close();conn.close();
		}
		catch (SQLException e)
		{
			System.out.println("failure!!");
		}
		return movieList;
	}

	@Override
	public void editSelect(Movies select, int find) {

		String url = "jdbc:mysql://localhost:3306/Movies";
		String username = "root";
		String password = "8160Prest!";
		Connection conn = null;
		String update = "UPDATE MovieInfo.Movies SET"
				+ " TITLE = '" + select.getTitle() + "'"
				+ ", RYEAR = "+ select.getYear()
				+ ", GENRE = '" + select.getGenre() + "'"
				+ ", STAR = '" + select.getLead() + "'"
				+ ", STUDIO = '" + select.getStudio() + "'"
				+ ", DIRECTOR = '" + select.getDirector() + "'"
				+ ", LENGTH =  " + select.getLength()
				+ ", RENTAL = " + select.getRental()
				+ ", COST = '" + select.getCost() + "'"
				+ ", REVENUE =' " + select.getRevenue() + "'"
				+ "WHERE ID = " +find;
		System.out.println(update);
	
		try
		{
			System.out.println("Entering Edit Movie Database");
			conn = DriverManager.getConnection(url, username, password );
			if (conn != null) {System.out.println("findSelect Connection Success");} else {System.out.println("findSelect Connection failure!!");}
			Statement statement = conn.createStatement();
			statement.executeUpdate(update);
		    statement.close();conn.close();
		}
		catch (SQLException e)
		{
			System.out.println("failure!!");
		}
	}

	@Override
	public Movies insert(Movies movies) {
		String url = "jdbc:mysql://localhost:3306/movieinfo";
		String username = "root";
		String password = "8160Prest!";
		Connection conn = null;
		String update = "INSERT INTO  MovieInfo.Movies (TITLE, RYEAR, GENRE, STAR, STUDIO, DIRECTOR, LENGTH, RENTAL, COST, REVENUE) VALUES"
				+ "(?,?,?,?,?,?,?,?,?,?)";
		int userId = 0;
		ResultSet rs = null;	
		try
		{
			conn = DriverManager.getConnection(url, username, password );
			if (conn != null) {System.out.println("Connection Success");} else {System.out.println("Connection failure!!");}
			PreparedStatement pstmt = conn.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
			{

				  pstmt.setString(1,movies.getTitle());
				  pstmt.setInt(2,movies.getYear());
		          pstmt.setString(3,movies.getGenre());
		          pstmt.setString(4,movies.getLead());
		          pstmt.setString(5,movies.getStudio());
		          pstmt.setString(6,movies.getDirector());
		          pstmt.setInt(7,movies.getLength());
		          pstmt.setFloat(8,movies.getRental());
		          pstmt.setString(9,movies.getCost());
		          pstmt.setString(10,movies.getRevenue());
		          
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
		return movies;
	}		
	
	@Override
	public void deleteSelect(int find) {

		String url = "jdbc:mysql://localhost:3306/Movies";
		String username = "root";
		String password = "8160Prest!";
		Connection conn = null;
		String update = "DELETE FROM MovieInfo.Movies WHERE ID = " + find;
		System.out.println(update);
	
		try
		{
			System.out.println("Entering Delet Movie Database");
			conn = DriverManager.getConnection(url, username, password );
			if (conn != null) {System.out.println("findSelect Connection Success");} else {System.out.println("findSelect Connection failure!!");}
			Statement statement = conn.createStatement();
			statement.executeUpdate(update);
		    statement.close();conn.close();
		}
		catch (SQLException e)
		{
			System.out.println("failure!!");
		}
	}

	@Override
	public Movies findSelect(int find) {
		String url = "jdbc:mysql://localhost:3306/movieinfo";
		String username = "root";
		String password = "8160Prest!";
		Connection conn = null;
		Movies movies = new Movies();
	
		try
		{
			System.out.println("Entering Database");
			conn = DriverManager.getConnection(url, username, password );
			
			if (conn != null) {System.out.println("Connection Success");} else {System.out.println("Connection failure!!");}
			String query = "SELECT * FROM MovieInfo.Movies WHERE ID = " + find;
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
		    while(result.next()) {
		    	  movies.setMovieID(result.getInt("ID"));
		    	  movies.setTitle(result.getString("Title"));
		          movies.setYear(result.getInt("RYEAR"));
		          movies.setGenre(result.getString("GENRE"));
		          movies.setLead(result.getString("STAR"));
		          movies.setStudio(result.getString("STUDIO"));
		          movies.setDirector(result.getString("DIRECTOR"));
		          movies.setLength(result.getInt("LENGTH"));
		          movies.setRental(result.getFloat("RENTAL"));
		          movies.setCost(result.getString("COST"));
		          movies.setRevenue(result.getString("REVENUE"));
		       }
		    result.close();
		    statement.close();conn.close();
		}
		catch (SQLException e)
		{
			System.out.println("failure!!");
		}
		return movies;

	}

}
