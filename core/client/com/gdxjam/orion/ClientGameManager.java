package com.gdxjam.orion;

import java.util.HashMap;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Array;
import com.gdxjam.orion.entities.ClientPlayer;

public class ClientGameManager {
	private static Game game;

	private static ClientPlayer player;
	private static HashMap<Integer, ClientPlayer> players = new HashMap<Integer, ClientPlayer>();

	// private static InputMultiplexer input = new InputMultiplexer();

	private ClientGameManager() {
	}

	public static void init(Game game) {
		ClientGameManager.game = game;
		Assets.load();
		while (!Assets.getManager().update()) {
			Assets.create();
		}
	}

	public static ClientPlayer getPlayer() {
		return player;
	}

	public static void setPlayer(ClientPlayer player) {
		ClientGameManager.player = player;
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

}
