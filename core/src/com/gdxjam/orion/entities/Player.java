package com.gdxjam.orion.entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.controls.ControlBehavior;
import com.gdxjam.orion.entities.ships.Ship;

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

	public Body getBody() {
		return ship.getBody();
	}

	public int getID() {
		return attributes.getID();
	}

	public ControlBehavior getBehavior() {
		return ship.getBehavior();
	}

	public float getSpeed() {
		return attributes.getSpeed();
	}

	public float getOrientation() {
		return ship.getBody().getAngle();

	}

	public Vector2 getPosition() {
		return ship.getBody().getPosition();
	}

	public float getAngle() {
		return ship.getBody().getAngle();
	}

}
