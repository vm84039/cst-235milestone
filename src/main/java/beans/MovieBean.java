package beans;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "movie")
@SessionScoped

public class MovieBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public List<MovieInfo> movies;  

    public List<MovieInfo> getMovies() 
    {
    	movies = new ArrayList<>();
		movies.add(new MovieInfo("Avatar",2009, "Fantasy", "Sam Worthington", "20th Century Fox", "James Cameron", 162, (float) 2.00, new BigInteger("237000000"), new BigInteger("2847000000")));
		movies.add(new MovieInfo("Titanic",1997, "Drama", "Leonardo DiCaprio", "Paramont Pictures", "James Cameron", 195, (float) 3.00, new BigInteger("200000000"),  new BigInteger("2195000000")));		
		movies.add(new MovieInfo("The Dark Knight",2008, "Fantasy", "Christian Bale", "Warner Bros", "Christopher Nolan",152 , (float) 3.00, new BigInteger("185000000"), new BigInteger("1005000000")));
		return movies;
    };
    

public static class MovieInfo {
	
	private String title;
	private int year; 
	private String genre; 
	private String lead; 
	private String studio; 
	private String director; 
	private int length; 
	private float rental;  
	private BigInteger cost; 
	private BigInteger revenue; 
	
	public MovieInfo(String title, int year, String genre, String lead, String studio, String director, int length, float rental,  BigInteger cost, BigInteger revenue) {
		this.title = title;
		this.year = year; 
		this.genre=genre; 
		this.lead=lead; 
		this.studio=studio; 
		this.director=director; 
		this.length=length; 
		this.rental=rental;  
		this.cost=cost; 
		this.revenue=revenue; 
	}
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getLead() {
		return lead;
	}


	public void setLead(String lead) {
		this.lead = lead;
	}


	public String getStudio() {
		return studio;
	}


	public void setStudio(String studio) {
		this.studio = studio;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public float getRental() {
		return rental;
	}


	public void setRental(float rental) {
		this.rental = rental;
	}


	public BigInteger getCost() {
		return cost;
	}


	public void setCost(BigInteger cost) {
		this.cost = cost;
	}


	public BigInteger getRevenue() {
		return revenue;
	}


	public void setRevenue(BigInteger revenue) {
		this.revenue = revenue;
	}

	


	}
}

