package com.gdxjam.orion;

import com.badlogic.gdx.Game;
import com.gdxjam.orion.screens.TempJoinGameScrren;

public class ClientMain extends Game {

	@Override
	public void create() {

		ClientGameManager.init(this);
		ClientGameManager.setScreen(new TempJoinGameScrren());
	}

}
