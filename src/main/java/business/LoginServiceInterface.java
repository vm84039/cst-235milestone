package business;

import javax.ejb.Local;

import beans.Login;
import beans.User;

@Local
public interface LoginServiceInterface {
	public User getUser();
	public void setUser(User user);
	public Boolean authenticate(Login user);

}
