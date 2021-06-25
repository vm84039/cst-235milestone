package business;

import java.util.List;
import javax.ejb.Local;

import beans.MovieBean;
import beans.MovieBean.Movies;


@Local
public interface MovieDatabaseServiceInterface {

	public List<Movies> getMovies();
	public void setMovies(List<Movies> movies); 
	public void addMovies(Movies movies);
	public Movies returnAdd();
	public Movies findSelect(int find);
	public void editMovies(Movies movies);
	public void deleteMovie(Movies movies);
	public void sendMovies(Movies movie);
}