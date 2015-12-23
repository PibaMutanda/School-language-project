package be.school.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;


/**
 * 
 * @author P. Mutanda
 *
 */
public class NotificationUtil {
	
	
	/** Sets a message string to be displayed by the next JSP in the Notification bar */
	public static void addNotificationMessage(String notification){
	    
		
		 HttpSession httpSession = ContextUtil.getHttpSession();
	       
	    @SuppressWarnings("unchecked")
		List<Notification> notifications=(List<Notification>) httpSession.getAttribute("notifications");
	    
	    if(notifications==null){
	    	notifications = new ArrayList<Notification>();
	    }
    	notifications.add(new Notification(notification));
	    
		httpSession.setAttribute("notifications",notifications);
	}
	
	static public class  Notification{
		String text;
		public Notification (String text){
			this.text=text;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		
		
	}

}
