package com.gdxjam.orion;

import java.util.HashMap;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
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
	private static World world;

	private static Pool<BulletK> bullets = Pools.get(BulletK.class, 1000000);

	private static Array<Entity> toBeAdded = new Array<Entity>();
	private static Array<Entity> active = new Array<Entity>();
	private static Array<Entity> toBeDestroyed = new Array<Entity>();

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

	public static Pool<BulletK> getBullets() {
		return bullets;
	}

	public static void addEntity(BodyDef bodyDef, FixtureDef fixture, Vector2 angle, BulletK bullet) {
		// TODO Auto-generated method stub

	}

	public static Array<Entity> getToBeAdded() {
		return toBeAdded;
	}

	public static Array<Entity> getActive() {
		return active;
	}

	public static Array<Entity> getToBeDestroyed() {
		return toBeDestroyed;
	}

}
