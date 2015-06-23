package com.gdxjam.orion.controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.entities.Player;
import com.gdxjam.orion.entities.ships.Ship;
import com.gdxjam.orion.utils.EntityFactory;

/**
 * These behaviors will define how a ship moves these should not handle client
 * requests (exiting to menu, toggling UI overlays)... these behaviors are
 * handled exclusively on the server angel are always in radians
 * */
public class AsteroidsControlBehavior implements ControlBehavior {

	private Ship ship;

	public AsteroidsControlBehavior() {
	}

	@Override
	public void init(Ship ship) {
		this.ship = ship;
	}

	@Override
	public void handleMouse(Vector2 position) {
	}

	@Override
	public void handleClick(Vector2 position) {
		Gdx.app.log("Debug", "Clicking" + position.x + " " + position.y);
		EntityFactory.createBullet(ship.getPosition(), position);
	}

	@Override
	public void handleKeyDown(int keycode) {
		switch (keycode) {
		case Keys.W:
			ship.forward = true;
			break;
		case Keys.A:
			ship.reverse = true;
			break;
		case Keys.S:
			ship.leftTurn = true;
			break;
		case Keys.D:
			ship.rightTurn = true;
			break;
		default:
			break;
		}

	}

	public void handleKeyUp(int keycode) {
		switch (keycode) {
		case Keys.W:
			ship.forward = false;
			break;
		case Keys.A:
			ship.reverse = false;
			break;
		case Keys.S:
			ship.leftTurn = false;
			break;
		case Keys.D:
			ship.rightTurn = false;
			break;
		default:
			break;
		}

	}
}
