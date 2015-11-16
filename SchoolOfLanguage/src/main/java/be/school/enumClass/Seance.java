package be.school.enumClass;

/**
 * Seance enum
 * 
 * @author P. Mutanda
 *
 */
public enum Seance {
	MATIN(1), SOIR(2);

	/**
	 * 
	 * @param index
	 */
	private Seance(int index) {
		this.index = index;
	}

	/**
	 * 
	 * @return
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * 
	 * @param index
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	private int index;

}
