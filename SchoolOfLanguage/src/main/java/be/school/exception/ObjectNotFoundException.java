package be.school.exception;

/**
 * ObjectNotFoundException class
 * @author P. Mutanda
 *
 */
public class ObjectNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	

	public ObjectNotFoundException() {
		super();
	}

	/**
	 * 
	 * @param arg0
	 * @param arg1
	 */
	public ObjectNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * 
	 * @param arg0
	 */
	public ObjectNotFoundException(String arg0) {
		super(arg0);
	}

	/**
	 * 
	 * @param arg0
	 */
	public ObjectNotFoundException(Throwable arg0) {
		super(arg0);
	}
		
}
