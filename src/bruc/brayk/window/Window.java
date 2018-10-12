package bruc.brayk.window;

import java.awt.Component;

import javax.swing.JFrame;

public class Window extends JFrame {

	private Renderer2D renderer2D;

	public Window(int width, int height, Renderer2D renderer2D) {

		this.setLocationRelativeTo(null);
		this.setLocationByPlatform(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("BrayK 2D view");
		//this.setSize(width, height);
		this.setAlwaysOnTop(true);

		this.renderer2D = renderer2D;
		this.add(renderer2D);
		this.pack();
	}

}
