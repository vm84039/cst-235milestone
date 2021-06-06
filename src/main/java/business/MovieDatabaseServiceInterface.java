package business;

import java.util.List;

import javax.ejb.Local;

import beans.MovieInfo;


@Local
public interface MovieDatabaseServiceInterface {

	public List<MovieInfo> getMovies();
	public void setMovies (List<MovieInfo> movies); 
}