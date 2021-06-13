package business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.MovieInfo;
import data.MovieDataService;

/* Session Bean implementation class RegistrationService
*/
@Stateless
@Local(MovieDatabaseServiceInterface.class)
@LocalBean
@Alternative
public class MovieDatabaseService implements MovieDatabaseServiceInterface {
	
	List<MovieInfo> movies = new ArrayList<MovieInfo>();
	MovieDataService service = new MovieDataService();

    public MovieDatabaseService() {
    	
    	
    }
    		
	@Override
	public void setMovies(List<MovieInfo> movies) {
		this.movies = movies;	
	}

	@Override
	public List<MovieInfo> getMovies() {
		// TODO Auto-generated method stub
		movies = service.findAll();
		System.out.println(Arrays.toString(movies.toArray()));
		return movies;
	}

	@Override
	public void addMovies(MovieInfo movies) {
		service.insert(movies);
		
	}
	



}