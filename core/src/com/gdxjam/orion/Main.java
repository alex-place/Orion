package com.gdxjam.orion;

import com.badlogic.gdx.Game;
import com.gdxjam.orion.screens.GameScreen;

public class Main extends Game {

	@Override
	public void create() {
		GameManager.init();
		setScreen(new GameScreen());
	}
}
