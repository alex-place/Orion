package com.gdxjam.orion.utils;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.controls.ControlBehavior;
import com.gdxjam.orion.entities.Entity;
import com.gdxjam.orion.entities.SolarSystem.Satellite;
import com.gdxjam.orion.entities.SolarSystem.Sun;
import com.gdxjam.orion.entities.bullets.LinearBullet;
import com.gdxjam.orion.entities.ships.Ship;

public class EntityFactory {

	static int locked = 0;
	static int unlocked = 0;

	public static void createBullet(Vector2 start, Vector2 target) {
		LinearBullet bullet = (LinearBullet) GameManager.getBulletPool().obtain();
		bullet.init(start, target, 1, 1);

	}

	public static Ship createShip(float x, float y, float angle, ControlBehavior behavior) {
		float size = 1;
		Polygon shape = new Polygon(new float[] { x, y, x + size, y, x + size, y + size, x, y + size });
		shape.setOrigin(x + (size / 2), y + (size / 2));

		return new Ship(shape, angle, behavior);

	}

	public static Sun createSun() {
		Polygon poly = new Polygon();
		poly.setVertices(Shapes.CIRCLE);
		poly.scale(1000);
		Sun sun = new Sun(poly, new Vector2(Constants.WORLD_WIDTH / 2, Constants.CAMERA_HEIGHT / 2));
		GameManager.getActiveEntities().add(sun);
		return sun;
	}

	public static Satellite createsatellite(Entity parent, float d) {
		Polygon poly = new Polygon();
		poly.setVertices(Shapes.CIRCLE);
		poly.scale(100);
		Satellite satellite = new Satellite(poly, parent, d);
		GameManager.getActiveEntities().add(satellite);
		return satellite;
	}
}
