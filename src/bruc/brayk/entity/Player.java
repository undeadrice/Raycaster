package bruc.brayk.entity;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

import bruc.brayk.math.GridVector;
import bruc.brayk.math.Helper;
import bruc.brayk.math.Vector;

public class Player implements DrawableEntity, PhysicEntity, Observable {

	// vector representing player position
	private Vector vector;
	// the rotation of the player
	private Double angle;
	//
	private List<Listener> listeners = new ArrayList<>();

	public Player(Vector vector, double angle) {
		this.vector = vector;
		this.angle = angle;
	}

	public Vector getVector() {
		return vector;
	}

	public void setVector(Vector vector) {
		this.vector = vector;
	}

	public double getAngle() {
		return angle;
	}

	public synchronized void setAngle(double angle) {
		this.angle = Helper.calcAngle(angle);
		notifyObservers();
		
	}

	@Override
	public void draw(Graphics2D g2d, AffineTransform transform, Camera camera, double sceneWidth, double sceneHeight) {
		g2d.setColor(Color.RED);
		g2d.drawString("Player vector: " + vector.toString(), 10, 20);
		g2d.drawString("Player grid - column :" + new GridVector(vector).getColumn() + " row: "
				+ new GridVector(vector).getRow(), 10, 40);
		g2d.drawString("Player grid position x: " + vector.getX() % 64 + " y: " + vector.getY() % 64, 10, 60);
		g2d.drawString("Player angle: " + angle, 10, 80);

		g2d.setColor(Color.BLACK);
		g2d.rotate(Math.toRadians(getAngle()), sceneWidth / 2, sceneHeight / 2);
	
		g2d.fillRect((int) sceneWidth / 2 - 10, (int) sceneHeight / 2 - 10, 20, 20);
		g2d.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(Color.RED);
		g2d.drawLine((int) sceneWidth / 2, (int) sceneHeight / 2, (int)sceneWidth/2, (int)sceneHeight/2-10);



	}

	@Override
	public void notifyObservers() {
		for (Listener l : listeners) {
			l.update();
		}

	}

	@Override
	public void addObserver(Listener l) {
		listeners.add(l);
	}

	@Override
	public void removeObserver(Listener l) {
		listeners.remove(l);

	}

}
