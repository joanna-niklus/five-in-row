package domain;

public class Marker {
	private int xLoc;
	private int yLoc;
	private String type;

	public Marker(int xLoc, int yLoc, String type) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.type = type;
	}

	public Marker(String type) {
		this.type = type;
	}

	public int getxLoc() {
		return xLoc;
	}

	public int getyLoc() {
		return yLoc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isEmpty() {
		return this.type.equals("_");
	}

	// public void setxLoc(int xLoc) {
	// this.xLoc = xLoc;
	// }
	// public void setyLoc(int yLoc) {
	// this.yLoc = yLoc;
	// }

	@Override
	public String toString() {
		// return this.type + "(" + this.xLoc + "," + this.yLoc + ")";
		return " " + this.type + " ";
	}

}
