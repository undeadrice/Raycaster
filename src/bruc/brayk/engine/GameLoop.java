package bruc.brayk.engine;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import bruc.brayk.controller.Controller;
import bruc.brayk.engine.physics.Physics;
import bruc.brayk.engine.raycasting.RayCaster;
import bruc.brayk.entity.Player;
import bruc.brayk.window.Renderer2D;
import bruc.brayk.window.Renderer3D;
import bruc.brayk.window.Window;
import bruc.brayk.window.Window3D;

public class GameLoop {

	private ExecutorService threads = Executors.newSingleThreadExecutor();
	private Window window;
	private Renderer2D renderer2D;
	private Controller controller;
	private Player player;
	private Physics physics;
	private RayCaster caster;
	
	private Renderer3D renderer3D;
	private Window3D window3D;
	

	public GameLoop(Window window, Renderer2D renderer2D, Controller controller, Physics physics, RayCaster caster, Window3D window3D, Renderer3D renderer3D) {
		this.window = window;
		this.renderer2D = renderer2D;
		this.controller = controller;
		this.physics = physics;
		this.caster = caster;
		this.window3D = window3D;
		this.renderer3D = renderer3D;
		
	}

	public void engage() {
		threads.execute(() -> {
			while (true) {
				try {
					caster.updateAndCheckRay();
					physics.next();
					window.repaint();
					window3D.repaint();
					Thread.sleep(1000 / 60);
				

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
	}

	public void halt() {

	}

	public void stop() {

	}

}
