package be.school.enumClass;

public enum Jour {
	LUNDI(1), MARDI(2), MERCREDI(3), JEUDI(4), VENDREDI(5);

	private Jour(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	private int index;
}
