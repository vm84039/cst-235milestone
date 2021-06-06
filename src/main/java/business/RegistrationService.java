package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import beans.User;

/* Session Bean implementation class RegistrationService
*/
@Stateless
@Local(RegistrationServiceInterface.class)
@LocalBean

public class RegistrationService implements RegistrationServiceInterface {
	
	List<User> users = new ArrayList<User>();
	@Inject
	RegistrationServiceInterface registration;

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}