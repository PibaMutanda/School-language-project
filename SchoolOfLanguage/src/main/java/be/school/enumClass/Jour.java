package be.school.enumClass;

/**
 * Enum Jour
 * 
 * @author P. Mutanda
 *
 */
public enum Jour {
	LUNDI(1), MARDI(2), MERCREDI(3), JEUDI(4), VENDREDI(5);
	/**
	 * 
	 * @param index
	 */
	private Jour(int index) {
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
