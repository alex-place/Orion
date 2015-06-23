package com.gdxjam.orion.utils;

import com.gdxjam.orion.entities.SolarSystem.Satellite;
import com.gdxjam.orion.entities.SolarSystem.Sun;

public class WorldGenerator {

	private WorldParameters p;

	public WorldGenerator(WorldParameters parameters) {
		this.p = parameters;
		createSolarSystem();
	}

	public void createSolarSystem() {
		Sun sun = EntityFactory.createSun();
		Satellite s1 = EntityFactory.createsatellite(sun, 1050);
		Satellite s3 = EntityFactory.createsatellite(s1,100);

	}
}
