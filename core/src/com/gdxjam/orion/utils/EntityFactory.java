package com.gdxjam.orion.utils;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.gdxjam.orion.controls.ControlBehavior;
import com.gdxjam.orion.entities.BulletK;
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

		return new Ship(shape, angle, behavior);

	}
}
