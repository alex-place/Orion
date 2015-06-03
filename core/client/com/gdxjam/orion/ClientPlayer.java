package com.gdxjam.orion;

import com.badlogic.gdx.math.Vector2;

public class ClientPlayer {

	private Vector2 position;
	private int id;

	public ClientPlayer() {
	}

	public ClientPlayer init(float x, float y, int id) {
		return init(new Vector2(x, y), id);
	}

	public ClientPlayer init(Vector2 position, int id) {
		this.position = position;
		this.id = id;
		return this;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Vector2 getPosition() {
		return position;
	}

	public int getId() {
		return id;
	}

}
