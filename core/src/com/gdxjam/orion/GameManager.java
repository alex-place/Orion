package com.gdxjam.orion;

import java.util.HashMap;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import com.gdxjam.orion.entities.BulletK;
import com.gdxjam.orion.entities.Entity;
import com.gdxjam.orion.entities.Player;

public class GameManager {

	private GameManager() {
	}

	private static HashMap<Integer, Player> players = new HashMap<Integer, Player>();

	private static Pool<BulletK> bullets = Pools.get(BulletK.class, 1000000);

	private static Array<Entity> active = new Array<Entity>();


	public static void init() {
		// world.setContactListener(new WorldContactListener());
	}

	public static HashMap<Integer, Player> getPlayers() {
		return players;
	}

	public static enum ShipType {
		DEFAULT, SHOOTER, UFO, TESTSHIP;
	}

	public static Pool<BulletK> getBullets() {
		return bullets;
	}



	public static Array<Entity> getActive() {
		return active;
	}


}
