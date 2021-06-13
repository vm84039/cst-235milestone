package beans;

import java.math.BigInteger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@ViewScoped 

public class MovieInfo {
	
	@NotNull() @Size(min=1, max=30)
	private String title;
	@NotNull() @Min(1900) @Max(2021)
	private int year; 
	private String genre; 
	@NotNull() @Size(min=2, max=40)
	private String lead; 
	private String studio; 
	private String director; 
	@NotNull() @Min(5) @Max(360)
	private int length; 
	@NotNull() @Min(1) @Max(100)
	private float rental; 
	private String cost;
	private String revenue;
	private BigInteger intCost;
	private BigInteger intRevenue;
	private int movieID;
	
	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public BigInteger getIntCost() {
		return intCost;
	}

	public void setIntCost(BigInteger intCost) {
		this.intCost = intCost;
	}

	public BigInteger getIntRevenue() {
		return intRevenue;
	}

	public void setIntRevenue(BigInteger intRevenue) {
		this.intRevenue = intRevenue;
	}


	
	
	public MovieInfo() {
		this.title = "";
		this.year = 1900; 
		this.genre= ""; 
		this.lead=""; 
		this.studio=""; 
		this.director="";
		this.length=0; 
		this.rental=0;  
		this.cost="0";
		this.revenue="0";
		this.intCost=new BigInteger(cost);
		this.intRevenue= new BigInteger(revenue);
	}
	
	public MovieInfo(String title, int year, String genre, String lead, String studio, String director, int length, float rental,  String cost, String revenue) {
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
		this.intCost = getBigInt(cost);
		this.intRevenue = getBigInt(revenue);
	}
	public BigInteger getBigInt(String str)
	{
		BigInteger num;
		boolean numeric= true;
		int i=0;
		if (str.isEmpty()) 
		{ 
			num = new BigInteger("0");
			return num;
		}
		while ((numeric !=false) && (i < str.length()))
		{
			char c = str.charAt(i);
			numeric = Character.isDigit(c);
			i++;
		}
		if (numeric == true) { num = new BigInteger(str);}
		else { num = new BigInteger("0");}
		return num;
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


	public String getCost() {
		return cost;
	}


	public void setCost(String cost) {
		this.cost = cost;
	}


	public String getRevenue() {
		return revenue;
	}


	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}

	


}
