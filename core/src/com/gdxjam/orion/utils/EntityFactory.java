package com.gdxjam.orion.utils;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.controls.ControlBehavior;
import com.gdxjam.orion.entities.BulletK;
import com.gdxjam.orion.entities.Entity;
import com.gdxjam.orion.entities.Satellite;
import com.gdxjam.orion.entities.Sun;
import com.gdxjam.orion.entities.ships.Ship;

public class EntityFactory {

	static int locked = 0;
	static int unlocked = 0;

	public static void createBulletK(float angle, Vector2 start) {
		BulletK bullet = new BulletK(angle, start);
	}

	public static Ship createShip(float x, float y, float angle, ControlBehavior behavior) {
		float size = 1;
		Polygon shape = new Polygon(new float[] { x, y, x + size, y, x + size, y + size, x, y + size });
		shape.setOrigin(x + (size / 2), y + (size / 2));

		return new Ship(shape, angle, behavior);

	}

	public static Sun createSun() {
		Polygon poly = new Polygon();
		float scale = 100;
		float[] vectors = { 3 * scale, 0 * scale, 4 * scale, 0 * scale, 5 * scale, 1 * scale, 6 * scale, 2 * scale, 7 * scale, 3 * scale, 7 * scale, 4 * scale,
				6 * scale, 5 * scale, 5 * scale, 6 * scale, 4 * scale, 7 * scale, 3 * scale, 7 * scale, 2 * scale, 6 * scale, 1 * scale, 5 * scale, 0 * scale,
				4 * scale, 0 * scale, 3 * scale, 1 * scale, 2 * scale, 2 * scale, 1 * scale }; // very
																								// ugly
																								// circle
																								// need
																								// replaced
		poly.setVertices(vectors);
		poly.scale(Float.MAX_VALUE); // this isn't doing anything
		Sun sun = new Sun(poly, new Vector2(Constants.WORLD_WIDTH / 2, Constants.CAMERA_HEIGHT / 2));
		GameManager.getActive().add(sun);
		return sun;
	}

	public static Satellite createsatellite(Entity parent) {
		Polygon poly = new Polygon();
		float scale = 10;
		float[] vectors = { 3 * scale, 0 * scale, 4 * scale, 0 * scale, 5 * scale, 1 * scale, 6 * scale, 2 * scale, 7 * scale, 3 * scale, 7 * scale, 4 * scale,
				6 * scale, 5 * scale, 5 * scale, 6 * scale, 4 * scale, 7 * scale, 3 * scale, 7 * scale, 2 * scale, 6 * scale, 1 * scale, 5 * scale, 0 * scale,
				4 * scale, 0 * scale, 3 * scale, 1 * scale, 2 * scale, 2 * scale, 1 * scale }; // very
																								// ugly
																								// circle
																								// need
																								// replaced
		poly.setVertices(vectors);
		Satellite satellite = new Satellite(poly, parent, 50f);
		GameManager.getActive().add(satellite);
		return satellite;
	}
}
