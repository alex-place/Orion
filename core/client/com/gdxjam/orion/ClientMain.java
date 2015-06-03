package com.gdxjam.orion;

import com.badlogic.gdx.Game;

public class ClientMain extends Game {

	@Override
	public void create() {
		setScreen(new ClientGameScreen());
	}

}
