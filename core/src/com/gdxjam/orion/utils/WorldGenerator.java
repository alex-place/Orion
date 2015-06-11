package com.gdxjam.orion.utils;

import sun.security.provider.Sun;

import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.entities.Planet;
import com.sun.xml.internal.stream.Entity;

public class WorldGenerator {

	private WorldParameters p;

	public WorldGenerator(WorldParameters parameters) {
		this.p = parameters;
		createBoundaries();
		createSolarSystem();
	}

	public void createBoundaries() {

		EntityFactory.createBoundry(new Vector2(0, 0), new Vector2(0, p.height));
		EntityFactory.createBoundry(new Vector2(p.width / 2, 0), new Vector2(p.width / 2, p.height));

		EntityFactory.createBoundry(new Vector2(0, p.height / 2), new Vector2(p.width, p.height / 2));
		EntityFactory.createBoundry(new Vector2(0, 0), new Vector2(p.width, 0));

		// EntityFactory.createBoundry(new Vector2(0, 0), new Vector2(0,
		// p.height));
		// EntityFactory.createBoundry(new Vector2(p.width, 0), new
		// Vector2(p.width, p.height));
		//
		// EntityFactory.createBoundry(new Vector2(0, p.width), new
		// Vector2(p.height, p.width));
		// EntityFactory.createBoundry(new Vector2(0, 0), new Vector2(p.height,
		// 0));

	}


	public void createSolarSystem() {
		com.gdxjam.orion.entities.Sun i = EntityFactory.createSun();
		Planet j = EntityFactory.createPlanet(50.0f, 5.0f, i);
		EntityFactory.createPlanet(10.0f, 2.0f, j);

	}
}
