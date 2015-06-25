package com.gdxjam.orion.utils;

import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.entities.Entity;
import com.gdxjam.orion.entities.SolarSystem.Satellite;
import com.gdxjam.orion.entities.SolarSystem.SatelliteParameters;
import com.gdxjam.orion.entities.SolarSystem.Sun;

public class WorldGenerator {

	private WorldParameters p;

	public WorldGenerator(WorldParameters parameters) {
		this.p = parameters;
		createSolarSystem();
	}

	public void createSolarSystem() {
		Sun sun = EntityFactory.createSun(new Vector2(0,0));
		SatelliteParameters p0 = new SatelliteParameters(sun, 150.f, 0.01f, 0.0f, 25.0f);
		Satellite s0 = new Satellite(p0);
		SatelliteParameters p1 = new SatelliteParameters(s0, 150.0f, 0.01f, 0.0f, 25.0f);
		Satellite s1 = new Satellite(p1);
		SatelliteParameters p2 = new SatelliteParameters(s1, 150.0f, 0.01f, 0.0f, 25.0f);
		Satellite s2 = new Satellite(p2);

	}}
