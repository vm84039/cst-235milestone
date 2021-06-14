package data;

import java.util.List;
import javax.ejb.Stateless;
import beans.Movies;

@Stateless
public interface MovieAccessInterface {
	public List<Movies> findAll();
	public void editSelect(Movies movies, int find);
	public void insert(Movies movies);
	public void deleteSelect(int find);
	public Movies findSelect(int find);
}
