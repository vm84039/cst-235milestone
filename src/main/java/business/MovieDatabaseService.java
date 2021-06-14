package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import beans.Movies;
import data.MovieDataService;

/* Session Bean implementation class RegistrationService
*/
@Stateless
@Local(MovieDatabaseServiceInterface.class)
@LocalBean

public class MovieDatabaseService implements MovieDatabaseServiceInterface {
	
	List<Movies> movies = new ArrayList<Movies>();
	MovieDataService service = new MovieDataService();
	Movies movie = new Movies();

    public MovieDatabaseService() {    }
    		
	@Override
	public void setMovies(List<Movies> movies) {
		this.movies = movies;	
	}

	@Override
	public List<Movies> getMovies() {
		// TODO Auto-generated method stub
		movies = service.findAll();
		return movies;
	}

	@Override
	public void addMovies(Movies movies) {
		service.insert(movies);
	}
	@Override
	public void editMovies(Movies movies, int find) {
		service.editSelect(movies, find);
	}

	@Override
	public Movies findSelect(int find) {
		movie = service.findSelect(find);
		return movie;

	}

	@Override
	public void delete(int find) {
		service.deleteSelect(find);	
	}



}