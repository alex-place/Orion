package com.gdxjam.orion.entities.ships;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.controls.ControlBehavior;
import com.gdxjam.orion.utils.Constants;

public class Ship {

	private float acceleration = 0;
	private float velocity = 0;
	private float velocityMax = 1;
	private float friction = 0;
	
	private float damping = 0.98f;
	private float speed = 1f;
	private float angle = 0;
	private float angleStep = 0.7f;
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
		
		if(velocity <= velocityMax && velocity >= -velocityMax){
			velocity += acceleration;
		}
		if(acceleration == 0){
			velocity *= damping;
		}
		

		velocity -= friction;		
		velocity *= delta;
		
		position.x += velocity * MathUtils.cos(angle);
		position.y += velocity * MathUtils.sin(angle);
		
		if(position.x < 0){
			position.x = 0;
		}
		if(position.x > Constants.WORLD_WIDTH){
			position.x = Constants.WORLD_WIDTH;
		}
		
		if(position.y < 0){
			position.y = 0;
		}
		if(position.y > Constants.WORLD_HEIGHT){
			position.y = Constants.WORLD_HEIGHT;
		}

		shape.setPosition(position.x, position.y);
		shape.setRotation(angle);
		acceleration = 0;

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
	public void setAngle(float angle){
		this.angle = angle;
	}
	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public void stepAnglePostive() {
		this.angle += angleStep;
	}
	
	public void stepAngleNegtive() {
		this.angle -= angleStep;
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

	public Polygon getPolygon() {
		return shape;
	}

}
