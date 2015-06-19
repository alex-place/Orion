package com.gdxjam.orion;

import java.util.HashMap;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Array;
import com.gdxjam.orion.GameManager.ShipType;
import com.gdxjam.orion.entities.ClientPlayer;

public class ClientGameManager {
	private static Game game;

	private static HashMap<Integer, ClientPlayer> players = new HashMap<Integer, ClientPlayer>();

	private static ShipType shipType;
	private static int id;

	private ClientGameManager() {
	}

	public static void init(Game game) {
		ClientGameManager.game = game;

	}

	public static HashMap<Integer, ClientPlayer> getPlayers() {
		return players;
	}

	public static void setPlayers(HashMap<Integer, ClientPlayer> players) {
		ClientGameManager.players = players;
	}

	public static void setScreen(Screen screen) {
		game.setScreen(screen);
	}

	public static void setShipType(ShipType selected) {
		ClientGameManager.shipType = selected;
	}

	public static int getID() {
		return id;
	}

	public static void setId(int id) {
		ClientGameManager.id = id;
	}

	public static ShipType getShipType() {
		return shipType;
	}

}
