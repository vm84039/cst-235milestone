package data;

import java.util.List;
import javax.ejb.Stateless;
import beans.MovieInfo;

@Stateless
public interface MovieAccessInterface {
	public List<MovieInfo> findAll();
	public MovieInfo findSelect(String column, String value);
	public void insert(MovieInfo movies);
	public void delete(String condition, String value);
}
