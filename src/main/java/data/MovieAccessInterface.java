package data;

import java.util.List;
import javax.ejb.Stateless;
import beans.MovieBean.Movies;

@Stateless
public interface MovieAccessInterface {
	public List<Movies> findAll();
	public void editSelect(Movies movies);
	public Movies insert(Movies movies);
	public void deleteSelect(Movies movies);
	public Movies findSelect(int find);
}
