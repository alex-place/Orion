package com.gdxjam.orion.entities.ships;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.controls.ControlBehavior;

public class Ship {

	private float acceleration = 0;
	private float velocity = 0;
	private float velocityMax = 100;
	private float friction = 0;
	private float damping = 0;
	private float angle = 0;
	private Vector2 position;
	private ControlBehavior behavior;
	private Polygon shape;

	public Ship(Polygon shape, float angle, ControlBehavior behavior) {
		this.shape = shape;
		position = new Vector2(0, 0);
		this.angle = angle;
		this.behavior = behavior;

	}

	public void update(float delta) {
		if (velocity < velocityMax) {
			velocity += acceleration - damping - friction;
		} else {
			velocity -= damping + friction;
		}

		position.x = velocity * MathUtils.cos(angle);
		position.y = velocity * MathUtils.sin(angle);

	}

	public ControlBehavior getBehavior() {
		return behavior;
	}

	public void setBehavior(ControlBehavior behavior) {
		this.behavior = behavior;
	}

	public Vector2 getPosition() {
		return position;
	}

	public float getX() {
		return position.x;
	}

	public float getY() {
		return position.y;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}

	public float getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(float acceleration) {
		this.acceleration = acceleration;
	}

	public float getVelocity() {
		return velocity;
	}

	public void setVelocity(float velocity) {
		this.velocity = velocity;
	}

	public float getVelocityMax() {
		return velocityMax;
	}

	public void setVelocityMax(float velocityMax) {
		this.velocityMax = velocityMax;
	}

	public float getFriction() {
		return friction;
	}

	public void setFriction(float friction) {
		this.friction = friction;
	}

	public float getDamping() {
		return damping;
	}

	public void setDamping(float damping) {
		this.damping = damping;
	}

	public Polygon getPolygon() {
		return shape;
	}

}
