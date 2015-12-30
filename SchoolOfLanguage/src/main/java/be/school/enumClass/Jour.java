package be.school.enumClass;

/**
 * Enum Jour
 * 
 * @author P. Mutanda
 *
 */
public enum Jour {
	LUNDI(0), MARDI(1), MERCREDI(2), JEUDI(3), VENDREDI(4);
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
