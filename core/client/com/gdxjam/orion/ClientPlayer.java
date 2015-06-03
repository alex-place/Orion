package com.gdxjam.orion;

import com.badlogic.gdx.math.Vector2;

public class ClientPlayer {

	private Vector2 position;
	private final int id;

	public ClientPlayer(float x, float y, int id) {
		this(new Vector2(x, y), id);
	}

	public ClientPlayer(Vector2 position, int id) {
		this.position = position;
		this.id = id;
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
