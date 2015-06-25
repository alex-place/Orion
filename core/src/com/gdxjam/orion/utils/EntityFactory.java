package com.gdxjam.orion.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.controls.ControlBehavior;
import com.gdxjam.orion.entities.Entity;
import com.gdxjam.orion.entities.SolarSystem.Satellite;
import com.gdxjam.orion.entities.SolarSystem.SatelliteParameters;
import com.gdxjam.orion.entities.SolarSystem.Sun;
import com.gdxjam.orion.entities.bullets.LinearBullet;
import com.gdxjam.orion.entities.ships.Ship;

public class EntityFactory {

	static int locked = 0;
	static int unlocked = 0;

	public static void createBullet(Vector2 start, Vector2 target) {
		LinearBullet bullet = (LinearBullet) GameManager.getLinearBulletPool().obtain();
		bullet.init(start, target, 10, 0.25f);
		Gdx.app.log(EntityFactory.class.getSimpleName(), "Start: " + start.toString());

	}

	public static Ship createShip(float x, float y, float angle, ControlBehavior behavior) {
		float size = 1;
		Polygon shape = new Polygon(new float[] { x, y, x + size, y, x + size, y + size, x, y + size });
		shape.setOrigin(x + (size / 2), y + (size / 2));

		return new Ship(shape, angle, behavior);

	}

	public static Sun createSun(Vector2 position) {
		Sun sun = new Sun(position);
		GameManager.getActiveEntities().add(sun);
		return sun; 
	}

	public static Satellite createsatellite(SatelliteParameters p) {
		Satellite satellite = new Satellite(p);
		GameManager.getActiveEntities().add(satellite);
		return satellite;
	}
}
