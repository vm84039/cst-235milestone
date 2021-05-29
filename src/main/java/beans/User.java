package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@ManagedBean
@ViewScoped 
public class User {
	@NotNull() @Size(min=5, max=15)
	private String firstName;
	@NotNull() @Size(min=5, max=15)
	private String lastName;
	@NotNull() @Min(1) @Max(12)
	private int month;
	@NotNull() @Min(1) @Max(31)
	private int day;
	@NotNull()@Min(1900) @Max(2010)
	private int year;
	@NotNull() @Email @Size(min=5, max=35)
	private String emailAddress;
	@NotNull() @Size(min=5, max=15)
	private String password;
	

	public User()
	{
        this.firstName = "";
        this.lastName = "";
        this.emailAddress = "";
        this.password = "";
        this.year = 1990;
        this.month = 1;
        this.day = 1;
	}
	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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