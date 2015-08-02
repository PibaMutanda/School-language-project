package be.school.enumClass;

public enum Seance {
	MATIN(1), SOIR(2);

	private Seance(int index) {
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
