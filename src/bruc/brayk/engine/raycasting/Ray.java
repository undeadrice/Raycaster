package bruc.brayk.engine.raycasting;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

import bruc.brayk.entity.Camera;
import bruc.brayk.entity.DrawableEntity;
import bruc.brayk.entity.WallType;
import bruc.brayk.math.Vector;

public class Ray implements DrawableEntity {

	private List<Vector> nodes;
	private WallType collidingWith = WallType.NO_WALL;
	private double deltaAngle = 0;
	private int column = 0;
	
	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public Ray(List<Vector> nodes) {
		this.nodes = nodes;
	}

	public Ray() {
		this.nodes = new ArrayList<>();
	}

	public double getDeltaAngle() {
		return deltaAngle;
	}

	public void setDeltaAngle(double deltaAngle) {
		this.deltaAngle = deltaAngle;
	}

	public WallType getCollidingWith() {
		return collidingWith;
	}

	public void setCollidingWith(WallType collidingWith) {
		this.collidingWith = collidingWith;
	}

	@Override
	public void draw(Graphics2D g2d, AffineTransform transform, Camera camera, double sceneWidth, double sceneHeight) {
		for (int i = 0; i < nodes.size() - 1; i++) {
			g2d.setColor(Color.RED);
			g2d.setStroke(new BasicStroke(1));
			if (nodes.get(i + 1) != null) {
				g2d.drawLine(nodes.get(i).getXAsInt() - camera.getVector().getXAsInt() + (int) sceneWidth / 2,
						nodes.get(i).getYAsInt() - camera.getVector().getYAsInt() + (int) sceneHeight / 2,
						nodes.get(i + 1).getXAsInt() - camera.getVector().getXAsInt() + (int) sceneWidth / 2,
						nodes.get(i + 1).getYAsInt() - camera.getVector().getYAsInt() + (int) sceneHeight / 2);
			}
		}
		//
		// for (int i = 1; i < nodes.size() - 1; i++) {
		// if(nodes.get(i+1)!= null) {
		// g2d.drawOval(nodes.get(i).getXAsInt() - camera.getVector().getXAsInt() +
		// (int) sceneWidth / 2 -2,
		// nodes.get(i).getYAsInt() - camera.getVector().getYAsInt() + (int) sceneHeight
		// / 2-2, 4,4);
		// }
		// }

	}

	public List<Vector> getNodes() {
		return nodes;
	}

	public void setNodes(List<Vector> nodes) {
		this.nodes = nodes;
	}

}
