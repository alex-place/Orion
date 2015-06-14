package com.gdxjam.orion.entities;

import com.badlogic.gdx.math.Vector2;

public class ClientBullet {

	public Vector2 position;
	public int id;

	public ClientBullet(Vector2 position, int id) {
		this.position = position;
		this.id = id;
	}

}
