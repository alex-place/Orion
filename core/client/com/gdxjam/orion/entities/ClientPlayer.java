package com.gdxjam.orion.entities;

import com.badlogic.gdx.math.Vector3;

public class ClientPlayer {

	private Vector3 position;
	private int id;

	public ClientPlayer() {
	}

	public ClientPlayer init(float x, float y, float rotation, int id) {
		return init(new Vector3(x, y, rotation), id);
	}

	public ClientPlayer init(Vector3 position, int id) {
		this.position = position;
		this.id = id;
		return this;
	}

	public void setPosition(Vector3 position) {
		this.position = position;
	}

	public Vector3 getPosition() {
		return position;
	}

	public int getId() {
		return id;
	}

}
