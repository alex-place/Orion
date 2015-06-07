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
public class DefaultControlBehavior implements ControlBehavior {

	private Player player;


	private final float speed = 1000;


	public DefaultControlBehavior() {
	}

	@Override
	public void init(Player player) {
		this.player = player;
	}

	@Override
	public void forward(float delta) {
		player.getBody()
				.applyForceToCenter(new Vector2(0, speed * delta), true);

	}

	@Override
	public void reverse(float delta) {
		player.getBody().applyForceToCenter(new Vector2(0, -speed * delta),
				true);
	}

	@Override
	public void left(float delta) {
		player.getBody().applyForceToCenter(new Vector2(-speed * delta, 0),
				true);
	}

	@Override
	public void right(float delta) {
		player.getBody()
				.applyForceToCenter(new Vector2(speed * delta, 0), true);
	}

	@Override
	public void lookAt(Vector2 position) {

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
