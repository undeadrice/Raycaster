package bruc.brayk.window;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import bruc.brayk.engine.raycasting.ProjectionPlane;
import bruc.brayk.entity.Camera;

public class Renderer3D extends JPanel {

	private Camera camera;
	private ProjectionPlane plane;
	
	public static final int DEF_WIDTH = 1440;
	public static final int DEF_HEIGHT = 64;
	
	public Renderer3D(Camera camera , ProjectionPlane plane) {
		this.camera = camera;
		this.plane = plane;
		this.setPreferredSize(new Dimension(DEF_WIDTH,DEF_HEIGHT));
		this.setIgnoreRepaint(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.scale(this.getWidth()/DEF_WIDTH, 1);
		
		plane.draw(g2d, camera, this.getWidth(), this.getHeight());
		
	}
	
}
