package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;

import beans.MovieInfo;

@Stateless
public class MovieDataService implements MovieAccessInterface {

	@Override
	public List<MovieInfo> findAll() {
		String url = "jdbc:mysql://localhost:3306/movieinfo";
		String username = "root";
		String password = "8160Prest!";
		Connection conn = null;
		List<MovieInfo> movieList = new ArrayList<MovieInfo>(); 
	
		try
		{
			System.out.println("Entering Database");
			conn = DriverManager.getConnection(url, username, password );
			
			if (conn != null) {System.out.println("Connection Success");} else {System.out.println("Connection failure!!");}
			String query = "SELECT * FROM MovieInfo.Movies";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
		    while(result.next()) {
		    	  MovieInfo movies = new MovieInfo();;
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
	public MovieInfo findSelect(String condition, String value) {

		MovieInfo select;
		String url = "jdbc:mysql://localhost:3306/MovieInfo";
		String username = "root";
		String password = "8160Prest!";
		Connection conn = null;
		List<MovieInfo> selectList = new ArrayList<MovieInfo>(); 
	
		try
		{
			conn = DriverManager.getConnection(url, username, password );
			if (conn != null) {System.out.println("findSelect Connection Success");} else {System.out.println("findSelect Connection failure!!");}
			String queryColumn = "SELECT ID, TITLE, YEAR, GENRE, LEAD, STUDIO, DIRECTOR, LENGTH, RENTAL,COST, REVENUE FROM testapp.orders Where "; 
			String queryWhere = queryType(condition, value);
			String query = queryColumn + queryWhere;
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);

			while(result.next()) {
		    	  select = new MovieInfo();
		          select.setYear(result.getInt("YEAR"));
		          select.setGenre(result.getString("GENRE"));
		          select.setLead(result.getString("LEAD"));
		          select.setStudio(result.getString("STUDIO"));
		          select.setDirector(result.getString("DIRECTOR"));
		          select.setLength(result.getInt("LENGTH"));
		          select.setRental(result.getFloat("RENTAL"));
		          select.setCost(result.getString("COST"));
		          select.setRevenue(result.getString("REVENUE"));
		          selectList.add(select);
		       }
		    result.close();
		    statement.close();conn.close();
		}
		catch (SQLException e)
		{
			System.out.println("failure!!");
		}
		select = new MovieInfo();
		return select;
	}
	public String queryType(String condition, String value)
	{
		String string;
		if ((condition == "YEAR") || (condition == "LENGTH") || (condition == "RENTAL"))
		{
			string = condition + " = " + value+")"; 
		}
		else
		{
			string = condition + " = '" + value + "')"; 
		}
		return string;
	}

	@Override
	public void insert(MovieInfo movies) {
		String url = "jdbc:mysql://localhost:3306/movieinfo";
		String username = "root";
		String password = "8160Prest!";
		Connection conn = null;
		String update = "INSERT INTO  MovieInfo.Movies (TITLE, RYEAR, GENRE, STAR, STUDIO, DIRECTOR, LENGTH, RENTAL, COST, REVENUE) VALUES"
				+ "(?,?,?,?,?,?,?,?,?)";
		int userId = 0;
		ResultSet rs = null;	
		try
		{
			conn = DriverManager.getConnection(url, username, password );
			if (conn != null) {System.out.println("Connection Success");} else {System.out.println("Connection failure!!");}
			PreparedStatement pstmt = conn.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
			{

		          pstmt.setInt(1,movies.getYear());
		          pstmt.setString(2,movies.getGenre());
		          pstmt.setString(3,movies.getLead());
		          pstmt.setString(4,movies.getStudio());
		          pstmt.setString(5,movies.getDirector());
		          pstmt.setInt(6,movies.getLength());
		          pstmt.setFloat(7,movies.getRental());
		          pstmt.setString(8,movies.getCost());
		          pstmt.setString(9,movies.getRevenue());
		          
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
	}		
	
	@Override
	public void delete(String condition, String value) {

		String url = "jdbc:mysql://localhost:3306/movieinfo";
		String username = "root";
		String password = "8160Prest!";
		Connection conn = null;
	
		try
		{
			conn = DriverManager.getConnection(url, username, password );
			if (conn != null) {System.out.println("finddelete Connection Success");} else {System.out.println("finddelete Connection failure!!");}
			String queryColumn = "DELETE  FROM MovieInfo.Movies Where "; 
			String queryWhere = queryType(condition, value);
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
