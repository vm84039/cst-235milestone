package business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import beans.User;

/* Session Bean implementation class LoginService
 */
@Stateless
@LocalBean
@ManagedBean


public class LoginService implements LoginServiceInterface {
	User user = new User();
    /* Default constructor. 
     */
    public LoginService() {
        // TODO Auto-generated constructor stub
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






}