package bruc.brayk.window;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import bruc.brayk.entity.Camera;
import bruc.brayk.entity.DrawableEntity;

public class Renderer2D extends JPanel {

	
	private final double WIDTH_640 = 640.0;
	private final double HEIGHT_640 = 640.0;
	
	private List<DrawableEntity> entities = new ArrayList<>();
	private Camera camera;
	
	public Renderer2D() {
		this.setIgnoreRepaint(true);
		this.setPreferredSize(new Dimension(640,640));
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		paintEntities(g2d);

	}
	
	public void paintEntities(Graphics2D g2d) {
		for(DrawableEntity entity : entities) {
			
			AffineTransform oldTransform = g2d.getTransform();
			AffineTransform currentTransform = g2d.getTransform();	
			double xFactor = this.getWidth()/this.WIDTH_640;
			double yFactor = this.getHeight()/this.HEIGHT_640;
			g2d.scale(xFactor, yFactor);
		
			entity.draw(g2d, currentTransform, camera, this.WIDTH_640, this.HEIGHT_640);
			g2d.setTransform(oldTransform);
		}
	}
	
	public void addDrawableEntity(DrawableEntity entity) {
		entities.add(entity);
	}
	
	public void removeDrawableEntity(DrawableEntity entity) {
		entities.remove(entity);
	}
	
	public void addDrawableEntities(List<DrawableEntity> entities) {
		entities.addAll(entities);
	}
	
	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	

}
