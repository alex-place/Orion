package com.gdxjam.orion.screens;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.entities.ClientPlayer;
import com.gdxjam.orion.input.DevGestureInput;
import com.gdxjam.orion.input.DevInputProcessor;
import com.gdxjam.orion.net.GameServer;
import com.gdxjam.orion.utils.Constants;
import com.gdxjam.orion.utils.WorldGenerator;
import com.gdxjam.orion.utils.WorldParameters;

public class GameScreen implements Screen {

	/**
	 * Keep in mind this will be discarded on switching to headless
	 * */
	Box2DDebugRenderer renderer = new Box2DDebugRenderer();
	OrthographicCamera camera;

	GameServer server;

	FPSLogger fps;

	@Override
	public void show() {
		fps = new FPSLogger();
		try {
			server = new GameServer();
		} catch (IOException e) {
			e.printStackTrace();
			Gdx.app.exit();
		}

		camera = new OrthographicCamera(Constants.CAMERA_WIDTH, Constants.CAMERA_HEIGHT);
		camera.position.set(5, 5, 0);
		camera.update();

		renderer = new Box2DDebugRenderer();
		renderer.setDrawVelocities(true);

		WorldParameters parameters = new WorldParameters();
		parameters.height = Constants.WORLD_HEIGHT;
		parameters.width = Constants.WORLD_WIDTH;
		new WorldGenerator(parameters);

		InputMultiplexer input = new InputMultiplexer();
		input.addProcessor(new GestureDetector(new DevGestureInput(camera)));
		input.addProcessor(new DevInputProcessor(camera));
		Gdx.input.setInputProcessor(input);

	}

	@Override
	public void render(float delta) {
		GameManager.getWorld().step(1 / 60f, 8, 8);
		server.update();
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl20.glClearColor(0, 0, 0, 1);
		renderer.render(GameManager.getWorld(), camera.combined);
		// fps.log();

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
		renderer.dispose();
		server.dispose();

	}

}
