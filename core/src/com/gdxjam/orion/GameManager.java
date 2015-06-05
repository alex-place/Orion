package com.gdxjam.orion;

import java.util.HashMap;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.gdxjam.orion.entities.Player;
import com.gdxjam.orion.net.GameServer;

public class GameManager {

	private GameManager() {
	}

	private static HashMap<Integer, Player> players = new HashMap<Integer, Player>();
	private static World world;

	public static void init() {
		world = new World(new Vector2(0, 0), true);
	}

	public static void init(Player player) {
	}

	public static HashMap<Integer, Player> getPlayers() {
		return players;
	}

	public static World getWorld() {
		return world;
	}

	public static enum ShipType {
		DEFAULT, FIGHTER;
	}

}
