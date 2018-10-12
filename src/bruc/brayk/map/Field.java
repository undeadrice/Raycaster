package bruc.brayk.map;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import bruc.brayk.entity.Camera;
import bruc.brayk.entity.DrawableEntity;
import bruc.brayk.entity.PhysicEntity;
import bruc.brayk.entity.WallType;
import bruc.brayk.math.GridVector;
import bruc.brayk.math.Vector;

public class Field implements DrawableEntity, PhysicEntity {

	private Vector vector;
	private GridVector gridVector;
	private WallType type;

	public Field(Vector vector) {
		this.vector = vector;
		this.type = WallType.NO_WALL;
		System.out.println(vector.getX());
		System.out.println(vector.getY());

	}

	public Field(GridVector gridVector) {

	}

	public Field(Vector vector, WallType type) {
		this.vector = vector;
		this.type = type;
	}

	@Override
	public void draw(Graphics2D g2d, AffineTransform transform, Camera camera, double sceneWidth, double sceneHeight) {
		
		if(this.vector.getX() < camera.getVector().getX() - 400 || this.vector.getX() > camera.getVector().getX() +400) {
			return;
		}
		if(this.vector.getY() < camera.getVector().getY() - 400 || this.vector.getY() > camera.getVector().getY() + 400) {
			return;
		}
	
		
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(2));
		g2d.drawRect(vector.getXAsInt() - camera.getVector().getXAsInt() + (int) sceneWidth / 2,
				vector.getYAsInt() - camera.getVector().getYAsInt() + (int) sceneHeight / 2, 64, 64);
		g2d.setStroke(new BasicStroke(1));
		if(type == WallType.NO_WALL) {
			return;
		}
		if (type == WallType.WALL) {
			g2d.setColor(Color.BLACK);
		
		} else if (type == WallType.RED_WALL) {
			g2d.setColor(Color.RED);

		}	
		else if(type == WallType.GREEN_WALL) {
			g2d.setColor(Color.GREEN);
		}
		else if(type == WallType.BRONZE_WALL) {
			g2d.setColor(Color.ORANGE);
		}
		g2d.fillRect(vector.getXAsInt() - camera.getVector().getXAsInt() + (int) sceneWidth / 2,
				vector.getYAsInt() - camera.getVector().getYAsInt() + (int) sceneHeight / 2, 64, 64);
		
		
	}

	public Vector getVector() {
		return vector;
	}

	public void setVector(Vector vector) {
		this.vector = vector;
	}

	public WallType getType() {
		return type;
	}

	public void setType(WallType type) {
		this.type = type;
	}

}
