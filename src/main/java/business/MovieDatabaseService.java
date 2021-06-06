package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.MovieInfo;

/* Session Bean implementation class RegistrationService
*/
@Stateless
@Local(MovieDatabaseServiceInterface.class)
@LocalBean
@Alternative
public class MovieDatabaseService implements MovieDatabaseServiceInterface {
	
	List<MovieInfo> movies = new ArrayList<MovieInfo>();

    public MovieDatabaseService() {
    		movies.add(new MovieInfo("Avatar",2009, "Fantasy", "Sam Worthington", "20th Century Fox", "James Cameron", 162, (float) 2.00, "237000000", "2847000000"));
    		movies.add(new MovieInfo("Titanic",1997, "Drama", "Leonardo DiCaprio", "Paramont Pictures", "James Cameron", 195, (float) 3.00, "200000000",  "2195000000"));		
    		movies.add(new MovieInfo("The Dark Knight",2008, "Fantasy", "Christian Bale", "Warner Bros", "Christopher Nolan",152 , (float) 3.00, "185000000", "1005000000"));
    }
	@Override
	public void setMovies(List<MovieInfo> movies) {
		this.movies = movies;
		
	}

	@Override
	public List<MovieInfo> getMovies() {
		// TODO Auto-generated method stub
		return movies;
	}



}