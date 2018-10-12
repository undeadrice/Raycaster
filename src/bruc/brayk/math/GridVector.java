package bruc.brayk.math;

@Deprecated
public class GridVector {

	private int column,row;

	
	// Grid vector represents the position in tiled map, each tile consists of 64x64 units
	public GridVector(int column, int row) {
		super();
		this.column = column;
		this.row = row;
	}
	
	public GridVector(Vector vector) {
		this.column = vector.getXAsInt()/64;
		this.row = vector.getYAsInt()/64;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
	
}
