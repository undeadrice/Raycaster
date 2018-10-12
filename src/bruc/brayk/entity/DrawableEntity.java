package bruc.brayk.entity;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public interface DrawableEntity {

	public void draw(Graphics2D g2d, AffineTransform transform , Camera camera, double sceneWidth, double sceneHeight);
	
	public default void draw() {
		
	};
	
}
