package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.MovieInfo;
import beans.User;
import business.LoginServiceInterface;
import business.MovieDatabaseServiceInterface;
import business.RegistrationServiceInterface;


@ManagedBean
@ViewScoped

public class formController {
	@Inject
	LoginServiceInterface login;
	@Inject
	RegistrationServiceInterface register;
	@Inject
	MovieDatabaseServiceInterface movieService;
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
	public String addMovieSubmit(MovieInfo movies) 
	{
		FacesContext context = FacesContext.getCurrentInstance();
		//put the movies object into the POST request
		movies = context.getApplication().evaluateExpressionGet(context, "#{movies}", MovieInfo.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("movies", movies);
		return "MovieCreated.xhtml";
	}
	public String EditMovie(MovieInfo movies) 
	{
		FacesContext context = FacesContext.getCurrentInstance();
		//put the movies object into the POST request
		movies = context.getApplication().evaluateExpressionGet(context, "#{movies}", MovieInfo.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("movies", movies);
		return "MovieDatabase.xhtml";
	}
	public LoginServiceInterface getUser()
	{
		return login;
	}
	public RegistrationServiceInterface getUsers()
	{
		return register;
	}
	public MovieDatabaseServiceInterface getMovieService()
	{
		return movieService;
	}
	
	

	
	

}
