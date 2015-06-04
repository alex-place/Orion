package com.gdxjam.orion.controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.Player;

/**
 * These behaviors will define how a ship moves these should not handle client
 * requests (exiting to menu, toggling UI overlays)... these behaviors are
 * handled exclusively on the server
 * */
public class DefaultControlBehavior implements ControlBehavior {

	private Player player;
	private final float speed = 1;

	public DefaultControlBehavior() {
	}

	@Override
	public void init(Player player) {
		this.player = player;
	}

	@Override
	public void forward(float delta) {
		float rotation = player.getBody().getAngle();
		Vector2 direction = new Vector2(MathUtils.cos(rotation),
				MathUtils.sin(rotation));
		if (direction.len() > 0) {
			direction.nor();
		}

		player.getBody().applyForceToCenter(
				new Vector2(direction.x * speed * delta, direction.y * speed
						* delta), true);

	}

	@Override
	public void reverse(float delta) {
		// TODO delete this shit
		player.getBody().applyForceToCenter(new Vector2(0, 100 * delta), true);

	}

	@Override
	public void left(float delta) {

	}

	@Override
	public void right(float delta) {

	}

	@Override
	public void lookAt(Vector2 position) {
		float angle = MathUtils.degreesToRadians
				* position.sub(player.getBody().getPosition()).angle();
		player.getBody().setTransform(player.getBody().getPosition(), angle);
	}

	@Override
	public void handleKey(int keycode) {
		switch (keycode) {
		case Keys.W:
		default:
			reverse(Gdx.graphics.getDeltaTime());
		}

	}

}
