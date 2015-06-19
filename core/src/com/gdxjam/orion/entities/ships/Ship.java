package com.gdxjam.orion.entities.ships;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.controls.ControlBehavior;
import com.gdxjam.orion.utils.Constants;

public class Ship {

	private float angle = 0, velocity = 0, friction = 0.98f, angleStep = 0, speed = 1f;

	private Vector2 newPosition;
	private Vector2 position;
	private ControlBehavior behavior;
	private Polygon shape;

	public boolean forward, back, left, right;

	public Ship(Polygon shape, float angle, ControlBehavior behavior) {
		this.shape = shape;
		position = new Vector2(0, 0);
		newPosition = new Vector2(0, 0);

		this.angle = angle;
		this.behavior = behavior;

	}

	public void update(float delta) {
		angle += angleStep;

		if (velocity != 0) {
			newPosition.x += MathUtils.sin(angle) * velocity;
			newPosition.y += MathUtils.cos(angle) * velocity;
		} else {
			newPosition.x *= friction;
			newPosition.y *= friction;
		}
		// if (newPosition.x < 0.0001 && newPosition.y < 0.0001) {
		// newPosition.x = 0;
		// newPosition.y = 0;
		// }

		position.x += newPosition.x;
		position.y += newPosition.y;

		// System.out.println(angle);

		shape.setRotation(angle * MathUtils.radiansToDegrees);
		shape.setPosition(position.x, position.y);

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

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public float getAngle() {
		return angle;
	}

	/**
	 * Sets the angle in radians
	 * */
	public void setAngle(float angle) {
		this.angle = angle;
	}

	public float getVelocity() {
		return velocity;
	}

	public void setVelocity(float velocity) {
		this.velocity = velocity;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public void setAngleStep(float angleStep) {
		this.angleStep = angleStep;
	}

	public Polygon getPolygon() {
		return shape;
	}

}
