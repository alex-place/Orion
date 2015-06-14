package com.gdxjam.orion.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.entities.Sattelite;
import com.gdxjam.orion.entities.Sattelite1;
import com.gdxjam.orion.entities.Sattelite1.SatteliteParameters1;
import com.gdxjam.orion.entities.Sun;
import com.gdxjam.orion.entities.Sattelite.SatteliteParameters;

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
		// The sun has a radius of 10
		Sun sun = EntityFactory.createSun();
		
		int planetsPerSide = 8;
		float radius;
		float dist = 5000;
		float angelStep;
		float startAngle;
		int numberOfMoons;
		float moonDist;
		for(int i = 0; i < planetsPerSide; i++){
			radius = MathUtils.random(300, 750);
			dist += MathUtils.random(radius+4000, 5000);
			angelStep = MathUtils.random(0.01f, -0.01f)+0.0001f;
			startAngle = MathUtils.random(0.0f, MathUtils.PI*2);
			numberOfMoons = MathUtils.random(0, 4);
			moonDist = radius;
			SatteliteParameters1 p = new SatteliteParameters1(sun, radius, dist, angelStep, startAngle);
			Sattelite1 planet = EntityFactory.createSattelite(p);
			for(int j = 0; j < numberOfMoons; j++){
				moonDist += MathUtils.random(100, 150);
				SatteliteParameters1 m = new SatteliteParameters1(planet, 50, moonDist, p.angelStep+0.02f, (MathUtils.PI/2)*j);
				Sattelite1 moon = EntityFactory.createSattelite(m);
			}
			
			
		}
		
		
		/*
		int planetsPerSide = (int)(MathUtils.random()*4)+4;
		float dist = 1500;
		float radius;
		for(int i = 0; i < planetsPerSide; i++){
			int sats = MathUtils.random(1, 4);
			
			dist = dist + MathUtils.random(500, 700);
			radius = MathUtils.random(75, 150);
			SatteliteParameters j = new SatteliteParameters(sun, radius, dist, 5000000, Float.MAX_VALUE, 1);
			Sattelite redPlanet = EntityFactory.createSattelite(j);
			for(int l = 0; l < sats; l++){
				SatteliteParameters m = new SatteliteParameters(redPlanet, MathUtils.random(25, 75), MathUtils.random(1, 50)+radius+100, 900000000, 1, 1);
				EntityFactory.createSattelite(m);
			}
			
			dist = dist + MathUtils.random(500, 700);
			radius = MathUtils.random(75, 150);
			SatteliteParameters k = new SatteliteParameters(sun, radius, -dist, (MathUtils.random()*500)+10000, 100, 1);
			Sattelite bluePlanet = EntityFactory.createSattelite(k);
			for(int l = 0; l < sats; l++){
				SatteliteParameters m = new SatteliteParameters(bluePlanet, (MathUtils.random()*2)+50, (MathUtils.random()*50)+radius+100, (MathUtils.random()*500)+10000, 1000000, 1);
				EntityFactory.createSattelite(m);
			}
		}


		Create a planet and its moon !VERY SENSITIVE RELATIONSHIP!
		SatteliteParameters p1 = new SatteliteParameters(sun, 2, 30, 360, 10, 1);
		Sattelite planet1 = EntityFactory.createSattelite(p1);

		SatteliteParameters m1 = new SatteliteParameters(planet1, 1, 6, 360, 10, 1f);
		EntityFactory.createSattelite(m1);

		// Create a planet and its moon !VERY SENSITIVE RELATIONSHIP!
		SatteliteParameters p2 = new SatteliteParameters(sun, 5, 300, 360, 10, 1);
		Sattelite planet2 = EntityFactory.createSattelite(p2);

		SatteliteParameters m = new SatteliteParameters(planet2, 2, 12, 360, 10, 1f);
		EntityFactory.createSattelite(m);
		*/

	}
}
