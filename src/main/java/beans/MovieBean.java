package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "movie")
@ViewScoped

public class MovieBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public List<MovieInfo> movies;  

    public List<MovieInfo> getMovies() 
    {
    	movies = new ArrayList<>();
		movies.add(new MovieInfo("Avatar",2009, "Fantasy", "Sam Worthington", "20th Century Fox", "James Cameron", 162, (float) 2.00, "237000000", "2847000000"));
		movies.add(new MovieInfo("Titanic",1997, "Drama", "Leonardo DiCaprio", "Paramont Pictures", "James Cameron", 195, (float) 3.00, "200000000",  "2195000000"));		
		movies.add(new MovieInfo("The Dark Knight",2008, "Fantasy", "Christian Bale", "Warner Bros", "Christopher Nolan",152 , (float) 3.00, "185000000", "1005000000"));
		return movies;
    };
    

}

