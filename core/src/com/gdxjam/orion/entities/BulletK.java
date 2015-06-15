package com.gdxjam.orion.entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool.Poolable;
import com.badlogic.gdx.utils.TimeUtils;

public class BulletK extends Entity implements Poolable {
	private float lenght = 2;
	private float angle;
	private double lifeTime;
	private Vector2 start;

	public BulletK(float angle, Vector2 start) {
		init(angle, start);
	}

	public BulletK() {
	}

	public void init(float angle, Vector2 start) {
		this.angle = angle;
		this.start = start;
		lifeTime = TimeUtils.millis() + 5000;
	}

	@Override
	public void reset() {

	}

}
