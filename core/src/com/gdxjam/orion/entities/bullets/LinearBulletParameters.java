package com.gdxjam.orion.entities.bullets;

public class LinearBulletParameters {
	public float speed;
	public float decay;
	public float radius;

	public LinearBulletParameters(float speed, float radius, float decay) {
		this.speed = speed;
		this.radius = radius;
		this.decay = decay;
	}

}