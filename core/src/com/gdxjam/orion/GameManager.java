package com.gdxjam.orion;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public class GameManager {

	private GameManager() {
	}

	private static Array<Player> players = new Array<Player>();
	private static World world;

	public static void init() {
		world = new World(new Vector2(0, 0), true);
	}

	public static void init(Player player) {
	}

	public static Array<Player> getPlayers() {
		return players;
	}

	public static World getWorld() {
		if (world == null)
			return new World(new Vector2(0, 0), true);
		return world;
	}

}
