package com.gdxjam.orion;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.gdxjam.orion.screens.ClientGameScreen;

public class ClientMain extends Game {

	@Override
	public void create() {
		setScreen(new ClientGameScreen());
	}

}
