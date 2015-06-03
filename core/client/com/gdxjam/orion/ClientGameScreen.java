package com.gdxjam.orion;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ClientGameScreen implements Screen {

	private GameClient client;
	private ClientPlayer player;

	private OrthographicCamera camera;
	private SpriteBatch batch;

	@Override
	public void show() {
		try {
			client = new GameClient();
		} catch (IOException e) {
			Gdx.app.exit();
			e.printStackTrace();
		}

		player = ClientGameManager.getPlayer();

		camera = new OrthographicCamera(10, 10);
		batch = new SpriteBatch();

	}

	@Override
	public void render(float delta) {

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {

	}

}
