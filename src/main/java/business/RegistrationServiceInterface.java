package business;

import java.util.List;

import javax.ejb.Local;

import beans.User;


@Local
public interface RegistrationServiceInterface {

	public List<User> getUsers();
	public void setUsers(List<User> users); 
	public void addUser(User user);
}