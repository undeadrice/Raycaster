package bruc.brayk.main;

import java.awt.EventQueue;

import bruc.brayk.controller.Controller;
import bruc.brayk.engine.GameLoop;
import bruc.brayk.engine.physics.Physics;
import bruc.brayk.engine.raycasting.ProjectionPlane;
import bruc.brayk.engine.raycasting.Ray;
import bruc.brayk.engine.raycasting.RayCaster;
import bruc.brayk.entity.Camera;
import bruc.brayk.entity.Player;
import bruc.brayk.map.Map;
import bruc.brayk.math.Vector;
import bruc.brayk.window.Renderer2D;
import bruc.brayk.window.Renderer3D;
import bruc.brayk.window.Window;
import bruc.brayk.window.Window3D;

public class Brayk {
	// just a plain window
	private static Window window;
	//
	private static Renderer2D renderer2D;
	//
	private static Window3D window3D;
	//
	private static Renderer3D renderer3D;
	//
	private static Player player;
	//
	private static Controller controller;
	//
	private static GameLoop loop;
	//
	private static Physics physics;
	//
	private static ProjectionPlane plane = new ProjectionPlane();
	//
	
	private static Map map;
	private static Camera camera;
	private static RayCaster caster;

	public static void main(String[] args) {
	
		
		
		player = new Player(new Vector(64*5+32, 64*5+32), 0);
		Camera camera = new Camera(player);
		player.addObserver(camera);
		map = Map.loadTestMap();
		caster = new RayCaster(camera,map);
		
		EventQueue.invokeLater(() -> {
			createWindow2D(camera);
			createWindow3D(camera);
		
			controller = new Controller(window);
			physics = new Physics(player, controller);
			loop = new GameLoop(window,renderer2D, controller, physics,caster,window3D,renderer3D);
			loop.engage();
			
	
			for(Ray ray : caster.getRays()) {
				renderer2D.addDrawableEntity(ray);
			}

			
		});

	}

	private static void createWindow2D(Camera camera) {
		renderer2D = new Renderer2D();
		renderer2D.setCamera(camera);
		renderer2D.addDrawableEntity(map);
		renderer2D.addDrawableEntity(player);
		window = new Window(640,640,renderer2D);
		window.setVisible(true);
	}
	
	private static void createWindow3D(Camera camera) {
		plane.setRays(caster.getRays());
		renderer3D = new Renderer3D(camera, plane);
		window3D = new Window3D(360, 64, renderer3D);
		window3D.setVisible(true);
	}

}
