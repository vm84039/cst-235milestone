package controllers;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import beans.Login;
import beans.MovieBean;
import beans.MovieBean.Movies;
import beans.User;
import business.LoginServiceInterface;
import business.MovieDatabaseServiceInterface;
import business.RegistrationServiceInterface;


@ManagedBean
@ViewScoped
@Stateless

public class formController {
	@Inject
	LoginServiceInterface login;
	@Inject
	RegistrationServiceInterface register;
	@Inject
	MovieDatabaseServiceInterface movieService;
	MovieBean movieList = new MovieBean();
	

	

	public String loadDatabase() 
	{
		movieList.init();
		return "MovieDatabase.xhtml";
	}
	public String registrationSubmit(User user) 
	{
		FacesContext context = FacesContext.getCurrentInstance();
		//put the user object into the POST request
		user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		register.addUser(user);
		return "registrationSuccess.xhtml";
	}
	public String Authenticate(Login log) 
	{
		FacesContext context = FacesContext.getCurrentInstance();
		//put the user object into the POST request
		log = context.getApplication().evaluateExpressionGet(context, "#{log}", Login.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("log", log);
		Boolean success = login.authenticate(log);
		if (success)
		{
			return "CustomerLoginSuccess.xhtml";
		}
		else
			return "CustomerLoginFailed.xhtml";
	}
	public String addMovieSubmit(Movies movies) 
	{
		FacesContext context = FacesContext.getCurrentInstance();
		//put the movies object into the POST request
		movies = context.getApplication().evaluateExpressionGet(context, "#{movies}", Movies.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("movies", movies);
		movieService.addMovies(movies);
		return "MovieCreated.xhtml";
	}


	public String deleteMovie(Movies movies) 
	{
		FacesContext context = FacesContext.getCurrentInstance();
		//put the movies object into the POST request
		movies = context.getApplication().evaluateExpressionGet(context, "#{movies}", Movies.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("movies", movies);
		movieService.deleteMovie(movies);
		return "MovieDatabase.xhtml";

	}


	
	

}
