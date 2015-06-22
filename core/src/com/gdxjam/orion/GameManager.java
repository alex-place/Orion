package com.gdxjam.orion;

import java.util.HashMap;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import com.gdxjam.orion.entities.Entity;
import com.gdxjam.orion.entities.Player;
import com.gdxjam.orion.entities.bullets.Projectile;

public class GameManager {

	private GameManager() {
	}

	private static HashMap<Integer, Player> players = new HashMap<Integer, Player>();

	private static Pool<Projectile> bulletPool = Pools.get(Projectile.class, 1000000);
	private static Array<Projectile> activeBullets = new Array<Projectile>(1000);

	private static Array<Entity> active = new Array<Entity>();

	public static void init() {
	}

	public static HashMap<Integer, Player> getPlayers() {
		return players;
	}

	public static enum ShipType {
		DEFAULT, SHOOTER, UFO, TESTSHIP;
	}

	public static Pool<Projectile> getBulletPool() {
		return bulletPool;
	}

	public static Array<Entity> getActiveEntities() {
		return active;
	}

	public static Array<Projectile> getActiveBullets() {
		return activeBullets;
	}

}
