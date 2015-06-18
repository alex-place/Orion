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
 * handled exclusively on the server
 * angel are always in radians
 * */
public class ShooterControlBehavior implements ControlBehavior {

	
	private Ship ship;

	public ShooterControlBehavior() {
	}

	@Override
	public void init(Ship ship) {
		this.ship = ship;
	}
	@Override
	public void forwardDown(float delta) {
		ship.setVelocity(ship.getSpeed());
	}

	@Override
	public void reverseDown(float delta) {
		ship.setVelocity(-ship.getSpeed());
		
	}

	@Override
	public void leftDown(float delta) {
		
	}

	@Override
	public void rightDown(float delta) {

	}

	@Override
	public void forwardUp(float delta) {
		ship.setVelocity(0.0f);
	}

	@Override
	public void reverseUp(float delta) {
		ship.setVelocity(0.0f);
		
	}

	@Override
	public void leftUp(float delta) {
		
	}

	@Override
	public void rightUp(float delta) {

		
	}


	@Override
	public void handleMouse(Vector2 position) {
		float i = MathUtils.atan2(ship.getPosition().y - position.y , ship.getPosition().x - position.x);
		if(i < 0){i= i + MathUtils.PI*2;}
		ship.setAngle(i);
	}

	@Override
	public void handleClick(Vector2 position) {
		Gdx.app.log("Debug", "Clicking" + position.x + " " + position.y);
		
	}

	@Override
	public void handleKeyDown(int keycode) {
		switch (keycode) {
		case Keys.W:
			forwardDown(Gdx.graphics.getDeltaTime());
			break;
		case Keys.A:
			leftDown(Gdx.graphics.getDeltaTime());
			break;
		case Keys.S:
			reverseDown(Gdx.graphics.getDeltaTime());
			break;
		case Keys.D:
			rightDown(Gdx.graphics.getDeltaTime());
			break;
		default:
			break;
		}

	}
	
	public void handleKeyUp(int keycode) {
		switch (keycode) {
		case Keys.W:
			forwardUp(Gdx.graphics.getDeltaTime());
			break;
		case Keys.A:
			leftUp(Gdx.graphics.getDeltaTime());
			break;
		case Keys.S:
			reverseUp(Gdx.graphics.getDeltaTime());
			break;
		case Keys.D:
			rightUp(Gdx.graphics.getDeltaTime());
			break;
		default:
			break;
		}

	}
}