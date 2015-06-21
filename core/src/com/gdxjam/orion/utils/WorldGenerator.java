package com.gdxjam.orion.utils;

public class WorldGenerator {

	private WorldParameters p;

	public WorldGenerator(WorldParameters parameters) {
		this.p = parameters;
		createSolarSystem();
	}

	public void createSolarSystem() {
		EntityFactory.createSun();
	}
}
