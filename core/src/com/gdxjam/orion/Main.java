package com.gdxjam.orion;

import com.badlogic.gdx.Game;

public class Main extends Game {

	@Override
	public void create() {
		GameManager.init();
		setScreen(new GameScreen());
	}
}