package com.gdxjam.orion.controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.entities.Player;

/**
 * These behaviors will define how a ship moves these should not handle client
 * requests (exiting to menu, toggling UI overlays)... these behaviors are
 * handled exclusively on the server
 * */
public class CruiserControlBehavior implements ControlBehavior {

	private Player player;
	private float rotation;
	private float rotationSpeed = 0.004f;

	private final float speed = 1000;

	public CruiserControlBehavior() {
	}

	@Override
	public void init(Player player) {
		this.player = player;
	}

	@Override
	public void forward(float delta) {
		rotation = player.getAngle();
		Vector2 direction = new Vector2(MathUtils.cos(rotation), MathUtils.sin(rotation));
		if (direction.len() > 0) {
			direction.nor();
		}
		// player.getBody().applyForce(new Vector2(direction.x * speed * delta,
		// direction.y * speed * delta), player.getBody().getWorldCenter(),
		// true);
	}

	@Override
	public void reverse(float delta) {
		rotation = player.getAngle();
		Vector2 direction = new Vector2(MathUtils.cos(rotation), MathUtils.sin(rotation));
		if (direction.len() > 0) {
			direction.nor();
		}
		// player.getBody().applyForce(new Vector2(direction.x * -speed * delta,
		// direction.y * -speed * delta), player.getBody().getWorldCenter(),
		// true);

	}

	@Override
	public void left(float delta) {
		// player.getBody().applyAngularImpulse(-rotationSpeed, true);
	}

	@Override
	public void right(float delta) {
		// player.getBody().applyAngularImpulse(rotationSpeed, true);
	}

	@Override
	public void handleMouse(Vector2 position) {

	}

	@Override
	public void handleKey(int keycode) {
		switch (keycode) {
		case Keys.W:
			forward(Gdx.graphics.getDeltaTime());
			break;
		case Keys.A:
			left(Gdx.graphics.getDeltaTime());
			break;
		case Keys.S:
			reverse(Gdx.graphics.getDeltaTime());
			break;
		case Keys.D:
			right(Gdx.graphics.getDeltaTime());
			break;
		default:
			break;
		}

	}

	@Override
	public void handleClick(Vector2 position) {
		// TODO Auto-generated method stub

	}

}
