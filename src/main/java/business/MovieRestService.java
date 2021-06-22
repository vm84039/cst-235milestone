package business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Movies;

@RequestScoped
@Path("/movies")
public class MovieRestService {
	
	@Inject
	MovieDatabaseServiceInterface service;
	
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movies> getMoviesAsJson()
	{
		return service.getMovies();
	}  
	
	@POST
	@Path("/putjson")
	@Produces( MediaType.APPLICATION_JSON )
	@Consumes( MediaType.APPLICATION_FORM_URLENCODED )
	public Movies addMoviesAsJson()
	{
		return service.returnAdd();
	}
	
	@GET
	@Path("/getxml")
	@Produces(MediaType.APPLICATION_XML)
	public  Movies[] getMoviesAsXml()
	{
		List<Movies> list = new ArrayList<Movies>();
		list = service.getMovies();
		Movies[] array = new Movies[list.size()];
		list.toArray(array);
		System.out.println("XML : " + Arrays.toString(array));
		return array;
	}
	@POST
	@Path("/putxml")
	@Produces( MediaType.APPLICATION_XML )
	@Consumes( MediaType.APPLICATION_FORM_URLENCODED )
	public Movies addMoviesAsXml()
	{
		return service.returnAdd();
	}

	

}
