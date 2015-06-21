package com.gdxjam.orion.screens;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Circle;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.entities.Entity;
import com.gdxjam.orion.entities.Player;
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
	// Box2DDebugRenderer renderer = new Box2DDebugRenderer();
	ShapeRenderer renderer;
	OrthographicCamera camera;

	GameServer server;

	FPSLogger fps;

	Circle circle = new Circle(0, 0, 100);

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

		renderer = new ShapeRenderer();
		renderer.setProjectionMatrix(camera.combined);

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
		server.update();
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl20.glClearColor(0, 0, 0, 1);
//update players
		for (Player player : GameManager.getPlayers().values()) {
			player.update(delta);
		}
//update entitys	
		for (Entity e : GameManager.getActive()) {
			e.update(delta);;
		}
//start debug render
		renderer.setProjectionMatrix(camera.combined);
		renderer.begin(ShapeType.Line);
		renderer.setColor(1, 0, 0, 1);
		// renderer.circle(circle.x, circle.y, circle.radius);
//debug render	players
		for (Player player : GameManager.getPlayers().values()) {
			renderer.polygon(player.getPolygon().getTransformedVertices());
		}
//debug render entitys
		for (Entity entity : GameManager.getActive()) {
			renderer.polygon(entity.getPolygon().getTransformedVertices());
		}

// Draw good stuff here

		renderer.end();

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
