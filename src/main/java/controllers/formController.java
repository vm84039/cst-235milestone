package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.MovieBean;
import beans.User;

@ManagedBean
@ViewScoped

public class formController {
	
	public String registrationSubmit(User user) 
	{
		FacesContext context = FacesContext.getCurrentInstance();
		//put the user object into the POST request
		user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "registrationSuccess.xhtml";
	}
	public String Authenticate(User user) 
	{
		FacesContext context = FacesContext.getCurrentInstance();
		//put the user object into the POST request
		user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "CustomerLoginSuccess.xhtml";
	}
	public String AddMovie(MovieBean movies) 
	{
		FacesContext context = FacesContext.getCurrentInstance();
		//put the movies object into the POST request
		movies = context.getApplication().evaluateExpressionGet(context, "#{movies}", MovieBean.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("movies", movies);
		return "MovieDatabase.xhtml";
	}
	public String EditMovie(MovieBean movies) 
	{
		FacesContext context = FacesContext.getCurrentInstance();
		//put the movies object into the POST request
		movies = context.getApplication().evaluateExpressionGet(context, "#{movies}", MovieBean.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("movies", movies);
		return "MovieDatabase.xhtml";
	}
	
	

}
