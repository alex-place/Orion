package com.gdxjam.orion.entities.bullets;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool.Poolable;

/**
 * An abstract definition of a projectile assuming that most (Not all) will have
 * a begin point and a target.
 * */
public abstract class Projectile implements Poolable {

	protected Vector2 start;
	protected Vector2 target;

	/**
	 * To implement poolable projectiles must have a 0-arg constructor
	 * */
	public Projectile() {
	}

	public void init() {
		init(new Vector2(), new Vector2());
	}

	public void init(Vector2 start, Vector2 target) {
		this.start = new Vector2(start);
		this.target = new Vector2(target);
	}

	public Vector2 getStart() {
		return start;
	}

	public Vector2 getTarget() {
		return target;
	}

	@Override
	public void reset() {
		start = null;
		target = null;
	}

	public abstract void update(float delta);

}
