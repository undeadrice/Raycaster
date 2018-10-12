package bruc.brayk.entity;

import java.awt.Graphics2D;

public interface Drawable3D {

	public void draw(Graphics2D g2d, Camera camera, double sceneWidth, double sceneHeight);
	
}
