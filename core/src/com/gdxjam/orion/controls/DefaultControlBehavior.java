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
		player.getBody().applyForceToCenter(new Vector2(0, speed * delta), true);

	}

	@Override
	public void reverse(float delta) {
		player.getBody().applyForceToCenter(new Vector2(0, -speed * delta), true);
	}

	@Override
	public void left(float delta) {
		player.getBody().applyForceToCenter(new Vector2(-speed * delta, 0), true);
	}

	@Override
	public void right(float delta) {
		player.getBody().applyForceToCenter(new Vector2(speed * delta, 0), true);
	}

	@Override
	public void handleMouse(Vector2 position) {

	}

	@Override
	public void handleClick(Vector2 position) {
		Gdx.app.log("Debug", "Clicking" + position.x + " " + position.y);
		if (attackCounter >= attackSpeed) {
			float angle = MathUtils.atan2(position.y, position.x) - MathUtils.atan2(player.getBody().getPosition().y, player.getBody().getPosition().x);
			EntityFactory.createBulletK(angle, player.getBody().getPosition());
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
