package com.gdxjam.orion.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gdxjam.orion.ClientMain;
import com.gdxjam.orion.utils.Constants;

public class ClientLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Constants.SCREEN_WIDTH;
		config.height = Constants.SCREEN_HEIGHT;
		config.vSyncEnabled = LauncherConstants.VSYNC;
		new LwjglApplication(new ClientMain(), config);
	}
}
