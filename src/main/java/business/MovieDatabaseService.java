package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import beans.MovieBean.Movies;
import data.MovieDataService;

/* Session Bean implementation class RegistrationService
*/
@Stateless
@Local(MovieDatabaseServiceInterface.class)
@LocalBean

public class MovieDatabaseService implements MovieDatabaseServiceInterface {
	
    @Resource(mappedName="java:/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName="java:/jms/queue/Order")
    private Queue queue;
    
	List<Movies> movies = new ArrayList<Movies>();
	MovieDataService service = new MovieDataService();
	public static Movies temp = new Movies();
	Movies movie = new Movies();
	

    public MovieDatabaseService() {    }
    		
	@Override
	public void setMovies(List<Movies> movies) {
		this.movies = movies;	
	}

	@Override
	public List<Movies> getMovies() {
		// TODO Auto-generated method stub
		movies = service.findAll();
		return movies;
	}

	@Override
	public void addMovies(Movies movies) {
			temp = movies;
			service.insert(movies);
	}
	@Override
	public Movies returnAdd()
	{
		return temp;
	}
	@Override
	public void editMovies(Movies movies) {
		service.editSelect(movies);
	}

	@Override
	public void findSelect(Movies movies) {
		this.movie = movies;
	}

	@Override
	public void deleteMovie(Movies movies) {
		service.deleteSelect(movies);	
	}

	@Override
	public void sendMovies(Movies movie) {
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
         //   TextMessage message1 = session.createTextMessage();
            ObjectMessage message2 = session.createObjectMessage();
            message2.setObject((Serializable) movies);
         //   message1.setText("This is test message");
        //    messageProducer.send(message1);
            messageProducer.send(message2);
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }		// TODO Auto-generated method stub
}
	



