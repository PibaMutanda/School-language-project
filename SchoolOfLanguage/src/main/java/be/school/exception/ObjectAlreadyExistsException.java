package be.school.exception;

public class ObjectAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 991423203045240768L;
	
	private String titre;
	
	public String toString(){
		return titre;
	}

	public ObjectAlreadyExistsException(String titre) {
		super(": "+titre.toString()+" existe déjà");
		this.titre = titre;
	}
   
}
