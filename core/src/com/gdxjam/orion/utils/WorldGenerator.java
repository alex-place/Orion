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
		for (int i = 0; i < planetsPerSide; i++) {
			radius = MathUtils.random(300, 750);
			dist += MathUtils.random(radius + 4000, 5000);
			angelStep = MathUtils.random(0.01f, -0.01f) + 0.0001f;
			startAngle = MathUtils.random(0.0f, MathUtils.PI * 2);
			numberOfMoons = MathUtils.random(0, 4);
			moonDist = radius;
			SatteliteParameters1 p = new SatteliteParameters1(sun, radius, dist, angelStep, startAngle);
			Sattelite1 planet = EntityFactory.createSattelite(p);
			for (int j = 0; j < numberOfMoons; j++) {
				moonDist += MathUtils.random(100, 150);
				SatteliteParameters1 m = new SatteliteParameters1(planet, 50, moonDist, p.angelStep + 0.02f, (MathUtils.PI / 2) * j);
				Sattelite1 moon = EntityFactory.createSattelite(m);
			}
		}
	}
}
