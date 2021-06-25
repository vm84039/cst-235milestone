package beans;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import business.MovieDatabaseService;
import business.MovieDatabaseServiceInterface;


@ManagedBean(name ="movies")
@SessionScoped
@Stateless

public class MovieBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
 	MovieDatabaseServiceInterface movieService = new MovieDatabaseService();
	private List<Movies> movies;


	@NotNull() @Size(min=1, max=30)
	String title;
	@NotNull() @Min(1900) @Max(2021)
	int year; 
	String genre; 
	@NotNull() @Size(min=2, max=40)
	String lead; 
	String studio; 
	String director; 
	@NotNull() @Min(5) @Max(360)
	int length; 
	@NotNull() @Min(1) @Max(100)
	float rental; 
	String cost;
	String revenue;
	boolean editable;
	boolean delete;
	
 
    
	@PostConstruct 
	public void init() 
	{
		movies = movieService.getMovies();
	}
    public List<Movies> getMovies() {
		return movies;
	}

	public void setMovies(List<Movies> movies) {
		this.movies = movies;
	}

    

    public void printList() {
	
    	  System.out.println("Printing Movie Titles"); 	
    	  for (Movies mov : movies)
	      { 		      
	           System.out.println(mov.getTitle()); 		
	      }
    }
    
    
    public String saveAction() {
    	//get all existing value but set "editable" to false 
        for (Movies movie  :  movies){
            if (movie.isEditable() == true)
            {
            	movieService.editMovies(movie);
            }
        	movie.setEditable(false);
        }
        //return to current page
        return null;
        
    }
    
    public String editAction(Movies movie) {
        
        movie.setEditable(true);
        return null;
    }
    public String deleteAction(Movies movie) {
        
        movie.setDelete(true);
    	return "DeleteConfirm.xhtml";
    }
    public String deleteActionConfirm() {
        for (Movies movie  :  movies){
            if (movie.isDelete() == true)
            {
            	movieService.deleteMovie(movie);
            	movies = movieService.getMovies();
            }
        	movie.setDelete(false);
        }
        return "MovieDatabase.xhtml";
    }

    	
    public String addAction() {
        
    	Movies movie = new Movies(this.title, this.year, this.genre, this.lead, this.studio, this.director, this.length, this.rental,  this.cost, this.revenue);
    	movieService.addMovies(movie);
        movies = movieService.getMovies();
        return "MovieDatabase.xhtml";
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
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public boolean isDelete() {
		return delete;
	}
	public void setDelete(boolean delete) {
		this.delete = delete;
	}


	//  @XmlRootElement(name = "Movies") 
    public static class Movies implements Serializable {
    	
		private static final long serialVersionUID = 1L;
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
    	boolean editable;
    	boolean delete;
    	
    	
    	public Movies() {
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
    	
    	public Movies(String title, int year, String genre, String lead, String studio, String director, int length, float rental,  String cost, String revenue) {
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
    	
    	public boolean isEditable() {
    		return editable;
    	}

    	public void setEditable(boolean editable) {
    		this.editable = editable;
    	}

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

		public boolean isDelete() {
			return delete;
		}

		public void setDelete(boolean delete) {
			this.delete = delete;
		}

    	

    	


    } 

    

}

