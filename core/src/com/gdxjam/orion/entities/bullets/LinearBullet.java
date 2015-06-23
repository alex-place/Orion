package com.gdxjam.orion.entities.bullets;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.GameManager;

/**
 * A linear bullet moves along a straight path at a set speed.
 * */
public class LinearBullet extends Projectile {

	/**
	 * Bullet trajectory angle in radians
	 * */

	LinearBulletParameters p;

	private float angle;
	private Vector2 position;

	public void init(Vector2 start, Vector2 target, float speed, float radius) {
		init(start, target, new LinearBulletParameters(speed, radius, -1));
	}

	public void init(Vector2 start, Vector2 target, LinearBulletParameters p) {
		this.start = new Vector2(start);
		this.target = new Vector2(target);
		this.p = p;
		Vector2 tmp = this.start.sub(target);
		angle = MathUtils.atan2(tmp.y, tmp.x);
		position = new Vector2(start);

		GameManager.getActiveBullets().add(this);

	}

	@Override
	public void update(float delta) {
		position.x += MathUtils.cos(angle) * p.speed * delta;
		position.y += MathUtils.sin(angle) * p.speed * delta;
	}

	@Override
	public void reset() {
		super.reset();
		angle = 0;
		position = null;
		p = null;
	}

	public Vector2 getPosition() {
		return position;
	}

	public float getRadius() {
		return p.radius;
	}

}
