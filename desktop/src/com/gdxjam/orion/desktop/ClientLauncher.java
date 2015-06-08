package com.gdxjam.orion.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;
import com.gdxjam.orion.Assets;
import com.gdxjam.orion.ClientMain;
import com.gdxjam.orion.utils.Constants;

public class ClientLauncher {
	public static void main(String[] arg) {

		if (Assets.rebuildAtlas) {
			Settings settings = new Settings();
			settings.maxWidth = 2048;
			settings.maxHeight = 2048;
			settings.debug = Assets.drawDebugOutline;
			try {
				TexturePacker.process(settings, "assets-raw", "../android/assets", "assets");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Constants.SCREEN_WIDTH;
		config.height = Constants.SCREEN_HEIGHT;
		config.vSyncEnabled = LauncherConstants.VSYNC;
		new LwjglApplication(new ClientMain(), config);
	}
}
