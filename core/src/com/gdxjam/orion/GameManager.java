package com.gdxjam.orion;

import java.util.HashMap;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.gdxjam.orion.entities.Entity;
import com.gdxjam.orion.entities.bullets.LinearBullet;
import com.gdxjam.orion.entities.bullets.Projectile;
import com.gdxjam.orion.entities.player.Player;

public class GameManager {

	private GameManager() {
	}

	private static HashMap<Integer, Player> players = new HashMap<Integer, Player>();

	private static Pool<LinearBullet> linearBulletPool = new Pool<LinearBullet>() {
		@Override
		protected LinearBullet newObject() {
			return new LinearBullet();
		}
	};

	private static Array<Projectile> activeBullets = new Array<Projectile>(1000);

	private static Array<Entity> active = new Array<Entity>();

	public static void init() {
	}

	public static HashMap<Integer, Player> getPlayers() {
		return players;
	}

	public static enum ShipType {
		ASTROIDS, SHOOTER, UFO, TEST;
	}

	public static Pool<LinearBullet> getLinearBulletPool() {
		return linearBulletPool;
	}

	public static Array<Entity> getActiveEntities() {
		return active;
	}

	public static Array<Projectile> getActiveBullets() {
		return activeBullets;
	}

}
