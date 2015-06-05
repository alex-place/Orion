package com.gdxjam.orion.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gdxjam.orion.Main;
import com.gdxjam.orion.utils.Constants;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = LauncherConstants.SCREEN_WIDTH;
		config.height = LauncherConstants.SCREEN_HEIGHT;

		new LwjglApplication(new Main(), config);
	}
}
