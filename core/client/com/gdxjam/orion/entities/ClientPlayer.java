package com.gdxjam.orion.entities;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Pool.Poolable;

public class ClientPlayer implements Poolable {

	public Vector3 position;
	public int id;

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

	@Override
	public void reset() {
		position = null;
		id = -1;
	}

}
