package bruc.brayk.engine.raycasting;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import bruc.brayk.entity.Camera;
import bruc.brayk.entity.Drawable3D;
import bruc.brayk.math.Helper;

public class ProjectionPlane implements Drawable3D {

	private List<Ray> rays = new ArrayList<>();
	
	
	public ProjectionPlane() {

	}

	public List<Ray> getRays() {
		return rays;
	}

	public void setRays(List<Ray> rays) {
		this.rays = rays;
	}

	@Override
	public void draw(Graphics2D g2d, Camera camera, double sceneWidth, double sceneHeight) {
		
		
		GradientPaint gp = new GradientPaint((int)sceneWidth/2, (int)sceneHeight/2, Color.white, (int)sceneWidth/2, 0, Color.blue);
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, (int)sceneWidth, (int)sceneHeight/2);
		
	
		

		
		
		for (int i = 0; i < rays.size(); i++) {
			int len = (int) Helper.pythagoreanC(rays.get(i).getNodes().get(0),
					rays.get(i).getNodes().get(rays.get(i).getNodes().size() - 1));
			
			
			switch (rays.get(i).getCollidingWith()) {
			case BLUE_WALL:
				g2d.setColor(Color.blue);
			case BRONZE_WALL:
				g2d.setColor(Color.ORANGE);
				break;
			case GREEN_WALL:
				g2d.setColor(Color.GREEN);
				break;
			case NO_WALL:
				g2d.setColor(new Color(0, 0, 0, 0));
				break;
			case RED_WALL:
				break;
			case TEXTURED_WALL:
				break;
			case WALL:
				g2d.setColor(Color.GRAY);
			
			default:
				break;

			}

	
			drawColumn(g2d, camera, sceneWidth, sceneHeight, len, i);

		}
	g2d.setColor(Color.GREEN);
		
		for(int i = 0 , j= 0 ; i < rays.size() ; i++) {
			g2d.drawString(Integer.toString(rays.get(i).getColumn()), i*2, j);
			j+= 30;
			if(j > 500) {
				j = 0;
			}
			
		}

	}

	private void drawColumn(Graphics2D g2d, Camera camera, double sceneWidth, double sceneHeight, int len, int pos) {
		
		double ll = Math.abs(Math.sin(Math.toRadians(Helper.calcAngle(360-(270+camera.getAngle()))))* len);
		
		
		
		int y = (int) sceneHeight / 2;
		
		int max = 2000;
		int ratio = (int)(max/ll);
		
		int upper = y - 20*ratio;
		int lower = y + 20*ratio;
		
		
	
	
		if(len>100) {
			g2d.setColor(g2d.getColor().darker());
		}
		
		if(len > 200) {
			g2d.setColor(g2d.getColor().darker());
		}
		if(len > 300) {
			g2d.setColor(g2d.getColor().darker());
		}
		
		g2d.drawLine(pos, y, pos, upper + len/4);
		g2d.drawLine(pos, y, pos, lower - len/4 );

	}

	private void drawLim(Graphics2D g2d, Camera camera, double sceneWidth, double sceneHeight, int len, int pos) {
		int y = (int) sceneHeight / 2;
		
		double ratio = len;
		System.out.println(ratio);
		
		int upper = y - 32;
		int lower = y + 32;
		g2d.setColor(Color.BLUE);
		g2d.drawLine(pos, upper + len / 2, pos, upper + len / 2 );
		g2d.drawLine(pos, lower - len / 2, pos, lower - len / 2);

	}
}
