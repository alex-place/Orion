package com.gdxjam.orion.entities.ships;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.controls.ControlBehavior;

public class Ship {

	private float speed = 1.0f;
	private ControlBehavior behavior;
	private float rotation;

	Polygon shape;

	public Ship(Polygon shape, float rotation, ControlBehavior behavior) {
		this.shape = shape;

		this.rotation = rotation;
		this.behavior = behavior;

	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public ControlBehavior getBehavior() {
		return behavior;
	}

	public void setBehavior(ControlBehavior behavior) {
		this.behavior = behavior;
	}

	public Vector2 getPosition() {
		return new Vector2(shape.getX(), shape.getY());
	}

	public float getX() {
		return shape.getX();
	}

	public float getY() {
		return shape.getY();
	}

	public void setPosition(Vector2 position) {
		shape.setPosition(position.x, position.y);
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

}
