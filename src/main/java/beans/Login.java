package beans;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@ManagedBean(name = "log")
@ViewScoped
@Stateless

public class Login {
	@NotNull() @Email @Size(min=5, max=35)
	private String emailAddress;
	@NotNull() @Size(min=2, max=35)
	private String password;
	
	public Login() {
		this.emailAddress="";
		this.password = "";
	}
	public Login(String emailAddress, String password) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
