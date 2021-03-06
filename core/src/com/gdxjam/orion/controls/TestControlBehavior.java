package com.gdxjam.orion.controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.entities.player.Player;
import com.gdxjam.orion.entities.ships.Ship;
import com.gdxjam.orion.utils.EntityFactory;

/**
 * These behaviors will define how a ship moves these should not handle client
 * requests (exiting to menu, toggling UI overlays)... these behaviors are
 * handled exclusively on the server
 * angel are always in radians
 * */
public class TestControlBehavior implements ControlBehavior {

	private boolean mouseLook = false;
	private Ship ship;

	public TestControlBehavior() {
	}

	@Override
	public void init(Ship ship) {
		System.out.println("TestControlBehavior");
		this.ship = ship;
	}
	@Override
	public void handleMouse(Vector2 position) {
		if(mouseLook){
			ship.setAngle(MathUtils.atan2(position.y-ship.getPosition().y, position.x-ship.getPosition().x));
		}
		
		
	}

	@Override
	public void handleClick(Vector2 position) {
		Gdx.app.log("Debug", "Clicking" + position.x + " " + position.y);
		EntityFactory.createBullet(ship.getOrigin(), position);		
	}

	@Override
	public void handleKeyDown(int keycode) {
		switch (keycode) {
			case Keys.W:
				ship.forward = true;
				break;
			case Keys.A:
				ship.leftStrafe = true;
				break;
			case Keys.S:
				ship.reverse = true;
				break;
			case Keys.D:
				ship.rightStrafe = true;
				break;
			case Keys.Q:
				ship.leftTurn = true;
				break;
			case Keys.E:
				ship.rightTurn = true;
				break;
			case Keys.T:
				ship.forwardMove = true;
				break;
			case Keys.G:
				ship.reverseMove = true;
				break;
			case Keys.F:
				ship.leftMove = true;
				break;
			case Keys.H:
				ship.rightMove = true;
				break;
			case Keys.M:
				if(mouseLook == false)
					mouseLook = true;
				else if(mouseLook == true)
					mouseLook = false;
				break;
			default:
				break;
		}

	}
	
	public void handleKeyUp(int keycode) {
		ship.moved = false;
		switch (keycode) {
			case Keys.W:
				ship.forward = false;
				break;
			case Keys.A:
				ship.leftStrafe = false;
				break;
			case Keys.S:
				ship.reverse = false;
				break;
			case Keys.D:
				ship.rightStrafe = false;
				break;
			case Keys.Q:
				ship.leftTurn = false;
				break;
			case Keys.E:
				ship.rightTurn = false;
				break;
			case Keys.T:
				ship.forwardMove = false;
				break;
			case Keys.G:
				ship.reverseMove = false;
				break;
			case Keys.F:
				ship.leftMove = false;
				break;
			case Keys.H:
				ship.rightMove = false;
				break;
			default:
				break;
		}
	}

}
