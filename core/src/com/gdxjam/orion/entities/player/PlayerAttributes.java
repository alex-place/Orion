package com.gdxjam.orion.entities.player;

public class PlayerAttributes {
	private int id;
	private final int speed;

	public PlayerAttributes(int id, int speed) {
		this.id = id;
		this.speed = speed;
	}

	public PlayerAttributes(int id) {
		this(id, 1);
	}

	public int getSpeed() {
		return speed;
	}

	public int getID() {
		return id;
	}

}