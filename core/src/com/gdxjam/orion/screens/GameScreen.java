package com.gdxjam.orion.screens;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.net.GameServer;

public class GameScreen implements Screen {

	/**
	 * Keep in mind this will be discarded on switching to headless
	 * */
	Box2DDebugRenderer renderer = new Box2DDebugRenderer();
	OrthographicCamera camera;

	GameServer server;

	@Override
	public void show() {

		try {
			server = new GameServer();
		} catch (IOException e) {
			e.printStackTrace();
			Gdx.app.exit();
		}

		camera = new OrthographicCamera(10, 10);
		renderer = new Box2DDebugRenderer();

	}

	@Override
	public void render(float delta) {
		update();

		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl20.glClearColor(0, 0, 0, 1);
		renderer.render(GameManager.getWorld(), camera.combined);

	}

	private void update() {
		GameManager.getWorld().step(1 / 60f, 8, 8);
		server.update();
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
