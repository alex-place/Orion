package com.gdxjam.orion.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.entities.BulletK;
import com.gdxjam.orion.entities.Entity;
import com.gdxjam.orion.entities.Sattelite;
import com.gdxjam.orion.entities.Sattelite.SatteliteParameters;
import com.gdxjam.orion.entities.Sattelite1;
import com.gdxjam.orion.entities.Sattelite1.SatteliteParameters1;
import com.gdxjam.orion.entities.Sun;

public class EntityFactory {

	static int locked = 0;
	static int unlocked = 0;

	public static void createBoundry(Vector2 start, Vector2 end) {
		FixtureDef def = new FixtureDef();
		EdgeShape edge = new EdgeShape();
		edge.set(start, end);
		def.shape = edge;
		def.isSensor = true;

		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.StaticBody;
		bodyDef.awake = false;
		bodyDef.position.set(start);

		GameManager.getWorld().createBody(bodyDef).createFixture(edge, 1.0f);
	}

	public static void createBulletK(float angle, Vector2 start) {
		BulletK bullet = new BulletK(angle, start);
	}

	public static Sun createSun() {
		Sun sun = new Sun(new Vector2(Constants.WORLD_WIDTH / 2, Constants.WORLD_HEIGHT / 2));
		GameManager.getToBeAdded().add(sun);
		return sun;

	}

	public static Sattelite createPlanet(float distance, float radius, Entity parent) {

		Sattelite planet = new Sattelite(distance, radius, parent);
		GameManager.getActive().add(planet);
		return planet;
	}

	public static Sattelite createSattelite(SatteliteParameters p) {
		Sattelite planet = new Sattelite(p);
		GameManager.getActive().add(planet);
		return planet;
	}

	public static Sattelite1 createSattelite(SatteliteParameters1 p) {
		Sattelite1 planet = new Sattelite1(p);
		GameManager.getToBeAdded().add(planet);
		return planet;
	}

}
