package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name = "movies")
@ViewScoped
@Stateless

public class MovieBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public List<Movies> movies;  

    
    public List<Movies> getList() {
        movies = new ArrayList<Movies>();
    	return movies;
    }

    

}

