package controllers;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Edit;
import beans.Login;
import beans.Movies;
import beans.User;
import business.LoginServiceInterface;
import business.MovieDatabaseService;
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
	public static Edit id = new Edit();
	public static Edit deleteId = new Edit();
	public static Movies deleteMovie = new Movies();
	
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
	public String editMovieSubmit(Movies movies) 
	{
			FacesContext context = FacesContext.getCurrentInstance();
			//put the movies object into the POST request
			movies = context.getApplication().evaluateExpressionGet(context, "#{movies}", Movies.class);
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("movies", movies);
			movieService.editMovies(movies, id.getID());
			return "MovieDatabase.xhtml";
	}
	public String deleteMovieSubmit(Edit edit) 
	{
			movieService.delete(id.getID());
			return "MovieDatabase.xhtml";
	}
	public String editMovie(Edit edit) 
	{
		Movies select = new Movies();
		FacesContext context = FacesContext.getCurrentInstance();
		//put the movies object into the POST request
		edit = context.getApplication().evaluateExpressionGet(context, "#{edit}", Edit.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("edit", edit);
		id.setID(edit.getID());
		select = movieService.findSelect(edit.getID());
		if (select.getMovieID() != 0)
		{
			return "EditMovieForm.xhtml";
		}
		else 
		{
				return "EditMovieFailed.xhtml";
		}
	}
	public String deleteMovie(Edit edit) 
	{
		FacesContext context = FacesContext.getCurrentInstance();
		//put the movies object into the POST request
		edit = context.getApplication().evaluateExpressionGet(context, "#{edit}", Edit.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("edit", edit);
		deleteId.setID(edit.getID());
		deleteMovie = movieService.findSelect(edit.getID());
		edit.setTitle(deleteMovie.getTitle());
		if (deleteMovie.getMovieID() != 0)
		{
			return "DeleteMovieForm.xhtml";
		}
		else 
		{
				return "EditMovieFailed.xhtml";
		}
	}

	public MovieDatabaseServiceInterface getMovieService()
	{
		movieService = new MovieDatabaseService();
		movieService.getMovies();
		return movieService;
	}
	

	
	

}
