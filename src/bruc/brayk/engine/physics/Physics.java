package bruc.brayk.engine.physics;

import bruc.brayk.controller.Controller;
import bruc.brayk.entity.Player;

public class Physics {

	private Player player;
	private Controller controller;

	public Physics(Player player, Controller controller) {
		this.player = player;
		this.controller = controller;
	}

	public void next() {
		applyControls();
		movePlayer();

	}

	public void movePlayer() {
		if (controller.iswPressed()) {
			applyForwardAngle(-3);
		}
		if (controller.issPressed()) {
			applyForwardAngle(3);
		}
		if (controller.isaPressed()) {
	
		}
		if (controller.isdPressed()) {
			
		}
	}

	public void applyControls() {
		if (controller.isqPressed()) {
			player.setAngle(player.getAngle() - 1);
		}
		if (controller.isePressed()) {
			player.setAngle(player.getAngle() + 1);
		}

	}

	public void applyForwardAngle(double speed) {
		double moveX = -Math.sin(Math.toRadians(player.getAngle())) * speed;
		double moveY = Math.cos(Math.toRadians(player.getAngle())) * speed;


		player.getVector().add(moveX, moveY);

	}

	public void applySideAngle(double speed) {
		double moveX = Math.cos(Math.toRadians(player.getAngle())) * speed;
		double moveY = Math.sin(Math.toRadians(player.getAngle())) * speed;


		player.getVector().add(moveY, moveX);

	}

}
