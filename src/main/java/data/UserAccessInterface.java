package data;

import java.util.List;

import beans.User;


public interface UserAccessInterface {
	public List<User> findAll();
	public User findSelect(String column);
	public void insert(User movies);
	public void delete(String condition, String value);

}
