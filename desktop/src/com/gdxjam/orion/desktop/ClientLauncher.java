package com.gdxjam.orion.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl.LwjglGraphics.SetDisplayModeCallback;
import com.gdxjam.orion.ClientMain;

public class ClientLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = LauncherConstants.SCREEN_WIDTH;
		config.height = LauncherConstants.SCREEN_HEIGHT;

		new LwjglApplication(new ClientMain(), config);
	}
}
