package com.gdxjam.orion.utils;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.controls.ControlBehavior;
import com.gdxjam.orion.entities.BulletK;
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
	public static Sun createSun(){
		float[] vectors = {
				3, 0,
				4, 0,
				5, 1,
				6, 2,
				7, 3,
				7, 4,
				6, 5,
				5, 6,
				4, 7,
				3, 7,
				2, 6,
				1, 5,
				0, 4,
				0, 3,
				1, 2,
				2, 1};
		Polygon poly = new Polygon();
		poly.setVertices(vectors);
		poly.scale(Float.MAX_VALUE);
		Sun sun = new  Sun(poly, new Vector2( 0, 0));
		GameManager.getActive().add(sun);
		return sun;
	}
}
