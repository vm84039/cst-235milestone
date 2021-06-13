package business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;

import beans.Login;
import beans.User;
import data.UserDataService;

/* Session Bean implementation class LoginService
 */
@Stateless
@LocalBean
@ManagedBean


public class LoginService implements LoginServiceInterface {
	User user = new User();
	UserDataService service = new UserDataService();

    public LoginService() {

    }

	@Override
	public beans.User getUser() {
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public void setUser(beans.User user) {
		this.user = user;
		
	}

	@Override
	public Boolean authenticate(Login log) {
		
		boolean f = false;
		User found = new User();
		found = service.findSelect(log.getEmailAddress());
		System.out.println("Found password:" + found.getPassword() + "Login Password:" + log.getPassword()+"...");
		if (log.getPassword().equals(found.getPassword()) )
		{
			f = true;
		}
			
		return f;
		
	}
}