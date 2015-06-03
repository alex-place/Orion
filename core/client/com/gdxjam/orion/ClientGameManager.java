package com.gdxjam.orion;

import com.badlogic.gdx.utils.Array;

public class ClientGameManager {

	private static ClientPlayer player;
	private static Array<ClientPlayer> players = new Array<ClientPlayer>();

	private ClientGameManager() {
	}

	public void init() {

	}

	public static ClientPlayer getPlayer() {
		return player;
	}

	public static void setPlayer(ClientPlayer player) {
		ClientGameManager.player = player;
	}

	public static Array<ClientPlayer> getPlayers() {
		return players;
	}

	public static void setPlayers(Array<ClientPlayer> players) {
		ClientGameManager.players = players;
	}

}
