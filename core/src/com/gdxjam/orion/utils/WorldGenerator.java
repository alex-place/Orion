package com.gdxjam.orion.utils;

import com.badlogic.gdx.math.Vector2;

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
	public void createSolarSystem(){
		EntityFactory.creatSun();
		EntityFactory.creatPlanet(5, new Vector2(25, 25));
		EntityFactory.creatPlanet(5, new Vector2(25, Constants.WORLD_HEIGHT/2));
		EntityFactory.creatPlanet(7, new Vector2(100, Constants.WORLD_HEIGHT/2));
	}
}
