package bruc.brayk.entity;

import bruc.brayk.math.Vector;

public class Camera implements Listener {

	private Vector vector;
	private Player player;
	private double angle;

	public Camera(Player player) {
		this.player = player;
		this.vector = player.getVector();
		this.angle = player.getAngle();
	};
	
	public Vector getVector() {
		return vector;
	}

	public void setVector(Vector vector) {
		this.vector = vector;
	}
	

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		if(angle < 0) {
			angle = 359.999;
		}
		this.angle = angle%360;
		
	}
	@Override
	public void update() {
		// cant be negative
//		vector.setX(-player.getVector().getX());
//		vector.setY(-player.getVector().getY());
		angle = player.getAngle();	
	
	}
	
}
