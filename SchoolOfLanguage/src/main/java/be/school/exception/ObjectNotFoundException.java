package be.school.exception;

public class ObjectNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String identifier;

	public ObjectNotFoundException(String identifier) {
		super();
		this.identifier = identifier;
	}

	@Override
	public String toString() {
		return identifier ;
	}
	
}
