package com.gdxjam.orion.controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.entities.Player;
import com.gdxjam.orion.utils.EntityFactory;

/**
 * These behaviors will define how a ship moves these should not handle client
 * requests (exiting to menu, toggling UI overlays)... these behaviors are
 * handled exclusively on the server
 * */
public class DefaultControlBehavior implements ControlBehavior {

	private Player player;

	private final float speed = 1000;

	private final float attackSpeed = 0;

	private float attackCounter = 0;

	public DefaultControlBehavior() {
	}

	@Override
	public void init(Player player) {
		this.player = player;
	}

	@Override
	public void forward(float delta) {
		player.setAngle(270);
		player.setAcceleration(5);
	}

	@Override
	public void reverse(float delta) {
		player.setAngle(90);
		player.setAcceleration(5);
	}

	@Override
	public void left(float delta) {
		player.setAngle(180);
		player.setAcceleration(5);
	}

	@Override
	public void right(float delta) {
		player.setAngle(0);
		player.setAcceleration(5);
	}

	@Override
	public void handleMouse(Vector2 position) {

	}

	@Override
	public void handleClick(Vector2 position) {
		Gdx.app.log("Debug", "Clicking" + position.x + " " + position.y);
		if (attackCounter >= attackSpeed) {

			// Create bullet

			attackCounter = 0;
		} else {
			attackCounter++;
		}
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

}
