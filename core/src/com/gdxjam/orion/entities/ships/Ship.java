package com.gdxjam.orion.entities.ships;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.controls.ControlBehavior;

public class Ship {
	public boolean forward, reverse, forwardMove, reverseMove, leftMove, rightMove, leftTurn, rightTurn, leftStrafe, rightStrafe, moved;
	private float angle = 0, friction = 0.98f, angleStep = 0.01f, speed = 0.001f, a;
	private Vector2 newPosition, position, velocity, origin;
	private ControlBehavior behavior;
	private Polygon shape;

	public Ship(Polygon shape, float angle, ControlBehavior behavior) {
		this.shape = shape;
		position = new Vector2(0, 0);
		newPosition = new Vector2(0, 0);
		velocity = new Vector2(0.005f, 0.010f);

		this.angle = angle;
		this.behavior = behavior;
		this.origin = new Vector2(shape.getOriginX(), shape.getOriginY());

	}

	public void update(float delta) {
		// basic 90* movement
		if (forwardMove) {
			move(1.57079633f, delta); // I'm hard coding the angle in radians.
		} else if (reverseMove) {
			move(4.71238898f, delta);
		}
		if (leftMove) {
			move(3.14159265f, delta);
		} else if (rightMove) {
			move(0, delta);
		}
		// movement base on angel
		if (rightTurn) {
			angle += angleStep;
		} else if (leftTurn) {
			angle -= angleStep;
		}
		if (rightStrafe) {
			move(validAngle(angle + 1.57079633f), delta);
		} else if (leftStrafe) {
			move(validAngle(angle - 1.57079633f), delta);
		}
		if (forward) {
			move(angle, delta);
		} else if (reverse) {
			move(validAngle(angle + 3.14159265f), delta);
		}
		// slow down and stop;
		if (!moved) {
			newPosition.y *= friction;
			newPosition.x *= friction;
		}

		moved = false;
		// To do: set max speed
		if (newPosition.y - position.y > 10) {
			// System.out.println(newPosition.y - position.y);
		}
		
		// add to position
		position.y += newPosition.y;
		position.x += newPosition.x;
		shape.setRotation(angle * MathUtils.radiansToDegrees);
		shape.setPosition(position.x, position.y);
	}

	private void move(float setAngle, float delta) {
		moved = true;
		newPosition.y += Math.sin(setAngle) * velocity.y * delta;
		newPosition.x += Math.cos(setAngle) * velocity.x * delta;
	}

	private float validAngle(float i) {
		// woks without it but this need fixed
		// if (i > 6.283185307179586476925286766559f){i =
		// 6.283185307179586476925286766559f % angle;}
		// if (i < 0){angle = 6.283185307179586476925286766559f + i;}
		return i;
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

	public void setAngle(float angle) {
		this.angle = angle;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public void stepAngle(float step) {
		this.angle += step;
	}

	public void setAngleStep(float angleStep) {
		this.angleStep = angleStep;
	}

	public Polygon getPolygon() {
		return shape;
	}

	public Vector2 getOrigin() {
		origin.x = position.x + 1.5f;
		origin.y = position.y + 1.5f;
		return origin;
	}

}
