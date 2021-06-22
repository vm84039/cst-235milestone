package business;

import java.util.List;

import javax.ejb.Local;

import beans.Movies;


@Local
public interface MovieDatabaseServiceInterface {

	public List<Movies> getMovies();
	public void setMovies (List<Movies> movies); 
	public void addMovies(Movies movies);
	public Movies returnAdd();
	public Movies findSelect(int find);
	public void editMovies(Movies movies, int find);
	public void delete(int find);
	public void sendMovies(Movies movie);
}