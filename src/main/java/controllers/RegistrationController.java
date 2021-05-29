package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.User;

@ManagedBean
@ViewScoped

public class RegistrationController {
	
	public String onSubmit(User user) 
	{
		FacesContext context = FacesContext.getCurrentInstance();
		//put the user object into the POST request
		context.getExternalContext().getRequestMap().put("user", user);
		return "registrationSuccess.xhtml";
	}

}
