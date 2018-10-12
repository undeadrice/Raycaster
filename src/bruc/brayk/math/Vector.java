package bruc.brayk.math;

public class Vector {

	private double x;
	private double y;

	public Vector(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	/**
	 *  creates a new Vector object placed in centre of the grid represented by given gridVector
	 *  a grid consists of 64x64 units, with means the vector will be placed at position 32x32 of the grid
	 * @param gridVector
	 */
	public Vector(GridVector gridVector) {
		this.x = gridVector.getColumn()*64+32;
		this.y = gridVector.getRow()*64+32;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void add(double x, double y) {
		this.x += x;
		this.y += y;
	}

	public void add(Vector other) {
		add(other.getX(), other.getY());
	}

	public int getXAsInt() {
		return (int) this.x;
	}

	public int getYAsInt() {
		return (int) this.y;
	}

	public int getColumn() {
		return (int)x/64;
	}
	
	public int getRow() {
		return (int)y/64;
	}
	
	public double getGridX() {
		return x%64;
	}
	
	public int getGridY() {
		return(int)y%64;
	}
	
	
	@Override
	public String toString() {
		return "Vector - x: " + x + " y:" + y;
	}

}
