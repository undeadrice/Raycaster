package bruc.brayk.map;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import bruc.brayk.entity.Camera;
import bruc.brayk.entity.DrawableEntity;
import bruc.brayk.entity.WallType;
import bruc.brayk.math.Vector;

public class Map implements DrawableEntity {

	private Field[][] fields;

	public Map(int cols, int rows) {
		fields = new Field[cols][rows];

	}

	@Override
	public void draw(Graphics2D g2d, AffineTransform transform, Camera camera, double sceneWidth, double sceneHeight) {
		for (Field[] cols : fields) {
			for (Field f : cols) {
				f.draw(g2d, transform, camera, sceneWidth, sceneHeight);
			}
		}

	}

	public static Map loadTestMap() {
		Field[][] f = new Field[100][100];
		for (int col = 0; col < f.length; col++) {

			for (int row = 0; row < f[0].length; row++) {
				Vector vector = new Vector(64 * col, 64 * row);
				f[col][row] = new Field(vector);
				if (row % 2 == 0 && col % 2 == 00)
					f[col][row].setType(WallType.WALL);
				if (row == 0) {
					f[col][row].setType(WallType.WALL);
				}
				if (row == 9) {
					f[col][row].setType(WallType.WALL);
				}

			}

		}
		for (int i = 0; i < 10; i++) {
			f[0][i].setType(WallType.WALL);
			f[9][i].setType(WallType.WALL);
		}
		f[0][0].setType(WallType.RED_WALL);
		f[0][1].setType(WallType.WALL);
		f[1][1].setType(WallType.WALL);
		f[4][3].setType(WallType.WALL);
		f[3][3].setType(WallType.WALL);
		f[3][1].setType(WallType.WALL);

		for (int i = 10; i < 20; i++) {
			f[i][0].setType(WallType.BRONZE_WALL);
			f[i][3].setType(WallType.GREEN_WALL);
		}

		Map map = new Map(100, 100);
		map.setFields(f);

		return map;
	}

	public static Map loadMap(File file) throws FileNotFoundException {

		Scanner scanner = new Scanner(file);
		String first = scanner.nextLine();

		Map map = new Map(first.length(), first.length());
		for (int i = 0; i < first.length(); i++) {

		}

		return map;
	}

	public Field[][] getFields() {
		return fields;
	}

	public void setFields(Field[][] fields) {
		this.fields = fields;
	}

	public boolean tileWalled(int col, int row) {
		if (fields[col][row].getType() != WallType.NO_WALL) {
			return true;
		}
		return false;

	}

	public boolean tileWalled(Vector vector) {
		if (vector.getColumn() < 0 || vector.getColumn() >= fields.length || vector.getRow() < 0
				|| vector.getRow() >= fields[0].length) {
			return true;
		}
		return fields[vector.getColumn()][vector.getRow()].getType() != WallType.NO_WALL;

	}

	public WallType getWallType(Vector v) {
		return fields[v.getColumn()][v.getRow()].getType();
	}

	public WallType getWallType(int col, int row) {
		return fields[col][row].getType();
	}

}
