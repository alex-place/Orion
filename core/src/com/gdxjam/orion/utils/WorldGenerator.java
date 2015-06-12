package com.gdxjam.orion.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.entities.Sattelite;
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
		
		
		SatteliteParameters p1 = new SatteliteParameters(sun, 2, 30, 360, 10, 1);
		Sattelite planet1 = EntityFactory.createSattelite(p1);
		
		SatteliteParameters p2 = new SatteliteParameters(sun, 2, -30, 360, 10, 1);
		Sattelite planet2 = EntityFactory.createSattelite(p2);
		
		int planetsPerSide = (int)(MathUtils.random()*4)+4;
		float dist = (MathUtils.random()*30)+20;
		for(int i = 0; i < planetsPerSide; i++){
			dist = dist + (MathUtils.random()*30)+20;
			
			SatteliteParameters j = new SatteliteParameters(sun, (MathUtils.random()*8)+2, dist, (MathUtils.random()*500)+10000, 10, 1);
			Sattelite redPlanet = EntityFactory.createSattelite(j);
			
			dist = dist + (MathUtils.random()*30)+20;
			
			SatteliteParameters k = new SatteliteParameters(sun, (MathUtils.random()*8)+2, -dist, (MathUtils.random()*500)+10000, 10, 1);
			Sattelite bluePlanet2 = EntityFactory.createSattelite(k);
		}


		/* Create a planet and its moon !VERY SENSITIVE RELATIONSHIP!
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
