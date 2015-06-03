package com.gdxjam.orion;

public class ClientGameManager {

	private static ClientPlayer player;

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

}
