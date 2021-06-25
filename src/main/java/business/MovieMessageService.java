package business;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import beans.MovieBean.Movies;



/**
 * Message-Driven Bean implementation class for: MovieMessageService
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/Movie"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:/jms/queue/Movie")
public class MovieMessageService implements MessageListener {
	@EJB
	MovieDatabaseService service;
	Movies send;
    /**
    /**
     * Default constructor. 
     */
    public void onMessage(Message message)  {
    	if (message instanceof Message) {
            try {
        		ObjectMessage objectMessage = (ObjectMessage) message;
        		send = new Movies();
        		send = (Movies)objectMessage.getObject();
        		service.sendMovies(send);
        		System.out.println("ON Message method:  "+ send.getMovieID());
            	
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }};
    }
}
