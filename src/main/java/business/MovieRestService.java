package business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
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
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
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
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public Movies addMoviesAsXml()
	{
		return service.returnAdd();
	}

	

}
