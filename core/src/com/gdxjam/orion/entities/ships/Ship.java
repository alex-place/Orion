package com.gdxjam.orion.entities.ships;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.controls.ControlBehavior;
import com.gdxjam.orion.utils.Constants;

public class Ship {
	public boolean forward, reverse, forwardMove, reverseMove, leftMove, rightMove, leftTurn, rightTurn, leftStrafe, rightStrafe;
	private float angle = 0, stepLenght = 0, friction = 0.98f, angleStep = 0.01f, speed = 0.001f, a;
	private Vector2 newPosition, position, velocity;
	private ControlBehavior behavior;
	private Polygon shape;
	private float i;

	
	public Ship(Polygon shape, float angle, ControlBehavior behavior) {
		this.shape = shape;
		position = new Vector2(0, 0);
		newPosition = new Vector2(0, 0);
		velocity = new Vector2(0.005f, 0.010f);

		this.angle = angle;
		this.behavior = behavior;

	}

	public void update(float delta) {
		System.out.println("angle = "+angle+" Dregress:"+angle*MathUtils.radiansToDegrees);
//basic 90* movement	
		if(forwardMove){
			move(1.57079633f);
		}
		else if(reverseMove){
			move(4.71238898f);
		}
		if(leftMove){
			move(3.14159265f);
		}
		else if(rightMove){
			move(0);
		}
//movement base on angel
		if (rightTurn){
			angle += angleStep;
			if (angle > MathUtils.PI*2){angle = MathUtils.PI*2 - angle;} 
		}
		else if (leftTurn){
			angle -= angleStep;
			if (angle < 0){angle = MathUtils.PI*2 + angle;}
		}
		if (rightStrafe){
			move(validAngle(angle+1.57079633f));
		}
		else if (leftStrafe){
			move(validAngle(angle-1.57079633f));
		}
		if (forward){
			move(angle);
			} 	
		else if (reverse){
			move(validAngle(angle+3.14159265f));} 
		else {
			newPosition.y *= friction;
			newPosition.x *= friction;
		}
		position.y += newPosition.y;
		position.x += newPosition.x;
		
		shape.setRotation(angle*MathUtils.radiansToDegrees);
		shape.setPosition(position.x, position.y);
	}
	private void move(float setAngle){
		newPosition.y += Math.sin(setAngle) * velocity.y;
		newPosition.x += Math.cos(setAngle) * velocity.x;
	}
	private float validAngle(float i){
		if (i > MathUtils.PI*2){i = MathUtils.PI*2 - angle;} 
		if (i < 0){angle = MathUtils.PI*2 + i;}
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
	public void setAngle(float angle){
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

}
