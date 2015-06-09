package com.gdxjam.orion;

import java.util.HashMap;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import com.gdxjam.orion.entities.Bullet;
import com.gdxjam.orion.entities.Player;

public class GameManager {

	private GameManager() {
	}

	private static HashMap<Integer, Player> players = new HashMap<Integer, Player>();
	private static World world;

	private static Pool<Bullet> bullets = Pools.get(Bullet.class, 1000000);

	public static void init() {
		world = new World(new Vector2(0, 0), true);
		// world.setContactListener(new WorldContactListener());
	}

	public static HashMap<Integer, Player> getPlayers() {
		return players;
	}

	public static World getWorld() {
		return world;
	}

	public static enum ShipType {
		DEFAULT, FIGHTER, CRUISER, CORVETTE;
	}

	public static Pool<Bullet> getBullets() {
		return bullets;
	}

}
