package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "user")
@ViewScoped
@Stateless

public class UserBean implements Serializable {

private static final long serialVersionUID = 1L;
    
    public List<User> users;  

    public List<User> getMovies() 
    {
    	users = new ArrayList<User>();
		return users;
    };
    
}
