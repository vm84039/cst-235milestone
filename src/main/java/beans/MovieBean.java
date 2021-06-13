package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import data.MovieDataService;

@ManagedBean(name = "movie")
@ViewScoped

public class MovieBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public List<MovieInfo> movies;  

    private MovieDataService movieService;
    
    @PostConstruct
    public void init() {
        movies = movieService.findAll();
    }

    

}

