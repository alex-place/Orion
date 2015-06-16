package com.gdxjam.orion.entities;

import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.controls.ControlBehavior;
import com.gdxjam.orion.entities.ships.Ship;
//import com.gdxjam.orion.entities.ships.pos;

public class Player extends Entity {

	private Ship ship;
	private PlayerAttributes attributes;

	public Player(PlayerAttributes attributes, Ship ship) {
		init(attributes, ship);
	}

	public void init(PlayerAttributes attributes, Ship ship) {
		this.attributes = attributes;
		this.ship = ship;

		GameManager.getPlayers().put(getID(), this);
	}

	public int getID() {
		return attributes.getID();
	}
	public void update(float delta){
		ship.update(delta);
	}
	public void setAngle(float angle){
		ship.setAngle(angle);
	}
	public void setAcceleration(float acceleration){
		ship.setAcceleration(acceleration);
	}
	public ControlBehavior getBehavior() {
		return ship.getBehavior();
	}

	public float getSpeed() {
		return ship.getVelocity();
	}

	public Vector2 getPosition() {
		return ship.getPosition();
	}

	public float getAngle() {
		return ship.getAngle();
	}

}
