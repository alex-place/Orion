package com.gdxjam.orion.utils;


import com.gdxjam.orion.entities.Entity;
import com.gdxjam.orion.entities.Satellite;
import com.gdxjam.orion.entities.Sun;

public class WorldGenerator {

	private WorldParameters p;

	public WorldGenerator(WorldParameters parameters) {
		this.p = parameters;
		createSolarSystem();
	}

	public void createSolarSystem() {
		Sun sun = EntityFactory.createSun();
		Satellite s1 = EntityFactory.createsatellite(sun);
		
	}
}
