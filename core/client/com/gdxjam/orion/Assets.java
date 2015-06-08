package com.gdxjam.orion;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable {

	public static final String TAG = Assets.class.getSimpleName();

	public static boolean rebuildAtlas = false;
	public static boolean drawDebugOutline = false;

	public static boolean loaded = false;

	public static AssetManager manager;
	public static AssetSquare square;

	public static AssetManager getManager() {
		if (manager == null) {
			manager = new AssetManager();
		}
		return manager;
	}

	public static final String TEXTURE_ATLAS_OBJECTS = "assets.atlas";
	public static final String SKIN = "skin/uiskin.json";

	public static Skin skin;

	public static void load() {
		getManager(); // Insure the manager exists
		manager.load(TEXTURE_ATLAS_OBJECTS, TextureAtlas.class);
		manager.load(SKIN, Skin.class);
		loaded = true;
	}

	public static void create() {
		TextureAtlas atlas = manager.get(TEXTURE_ATLAS_OBJECTS);

		skin = manager.get(SKIN);

	}

	public class AssetSquare {
		AtlasRegion reg;

		public AssetSquare(TextureAtlas atlas) {
			reg = atlas.findRegion("square");
		}
	}

	@Override
	public void dispose() {
		manager.dispose();
	}

}