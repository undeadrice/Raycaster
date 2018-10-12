package bruc.brayk.window;

import java.awt.Component;

import javax.swing.JFrame;

public class Window3D extends JFrame {

	private Renderer3D renderer3D;

	public Window3D(int width, int height, Renderer3D renderer3D) {

		this.setLocationRelativeTo(null);
		this.setLocationByPlatform(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("BrayK 3D view");
		//this.setSize(width, height);
		this.setAlwaysOnTop(true);

		this.renderer3D = renderer3D;
		this.add(renderer3D);
		this.pack();
	}

}
