package com.gdxjam.orion.utils;

import com.badlogic.gdx.math.Vector2;

public class WorldGenerator {

	private WorldParameters p;

	public WorldGenerator(WorldParameters parameters) {
		this.p = parameters;
		createBoundaries();
	}

	public void createBoundaries() {
		EntityFactory.createBoundry(new Vector2(0, 0), new Vector2(0, p.height));
		EntityFactory.createBoundry(new Vector2(0, 0), new Vector2(p.width, 0));
		EntityFactory.createBoundry(new Vector2(p.width, p.height), new Vector2(p.width, 0));
		EntityFactory.createBoundry(new Vector2(p.width, p.height), new Vector2(0, p.height));
	}

}
