package com.gdxjam.orion.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gdxjam.orion.ClientMain;

public class ClientLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1080;
		config.height = 960;
		new LwjglApplication(new ClientMain(), config);
	}
}
