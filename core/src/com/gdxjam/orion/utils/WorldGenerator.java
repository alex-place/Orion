package com.gdxjam.orion.utils;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.entities.Entity;
import com.gdxjam.orion.entities.SolarSystem.Astroids;
import com.gdxjam.orion.entities.SolarSystem.Satellite;
import com.gdxjam.orion.entities.SolarSystem.SatelliteParameters;
import com.gdxjam.orion.entities.SolarSystem.Sun;
import com.gdxjam.orion.entities.SolarSystem.World;

public class WorldGenerator {

	private WorldParameters p;

	public WorldGenerator(WorldParameters parameters) {
		this.p = parameters;
		createSolarSystem();
	}

	public void createSolarSystem() {
		World world = new World();
		
		Astroids astroid1 = new Astroids(new Vector2(Constants.WORLD_HEIGHT/2,Constants.WORLD_WIDTH/2));
		Astroids astroid2 = new Astroids(new Vector2(Constants.WORLD_HEIGHT/2,Constants.WORLD_WIDTH/2));
		Astroids astroid3 = new Astroids(new Vector2(Constants.WORLD_HEIGHT/2,Constants.WORLD_WIDTH/2));
		
		Sun sun = new Sun(new Vector2(Constants.WORLD_HEIGHT/2,Constants.WORLD_WIDTH/2));
		
		SatelliteParameters p1 = new SatelliteParameters(sun, 200, -0.005f, 1.5f, 50);
		Satellite s1 = new Satellite(p1);	
		SatelliteParameters p2 = new SatelliteParameters(sun, 400, 0.007f, 6.0f, 45);
		Satellite s2 = new Satellite(p2);
		SatelliteParameters mP1 = new SatelliteParameters(s2, 75, 0.009f, 2.9f, 15);
		Satellite m1 = new Satellite(mP1);
		SatelliteParameters p3 = new SatelliteParameters(sun, 600, 0.009f, 6.0f, 65);
		Satellite s3 = new Satellite(p3);
		SatelliteParameters p4 = new SatelliteParameters(sun, 800, -0.002f, 6.0f, 40);
		Satellite s4 = new Satellite(p4);
		SatelliteParameters p5 = new SatelliteParameters(sun, 1000, 0.006f, 6.0f, 75);
		Satellite s5 = new Satellite(p5);
		

	}}
