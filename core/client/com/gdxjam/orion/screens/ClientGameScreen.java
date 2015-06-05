package com.gdxjam.orion.screens;

import java.io.IOException;

import utils.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.gdxjam.orion.ClientGameManager;
import com.gdxjam.orion.entities.ClientPlayer;
import com.gdxjam.orion.input.DefaultInputHandler;
import com.gdxjam.orion.net.GameClient;
import com.gdxjam.orion.net.Network.RequestUpdate;

public class ClientGameScreen implements Screen {

	private GameClient client;

	private OrthographicCamera camera;
	private SpriteBatch batch;

	private DefaultInputHandler input;

	private Texture green;

	@Override
	public void show() {
		try {
			client = new GameClient();
		} catch (IOException e) {
			Gdx.app.exit();
			e.printStackTrace();
		}

		camera = new OrthographicCamera(Constants.CAMERA_WIDTH, Constants.CAMERA_HEIGHT);
		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);

		green = new Texture(Gdx.files.internal("green.png"));

		// input = new DefaultInputHandler(client);
		// ClientGameManager.getInput().addProcessor(input);

		Gdx.input.setInputProcessor(ClientGameManager.getInput());

	}

	@Override
	public void render(float delta) {
		handleInput();
		client.update();
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl20.glClearColor(0, 0, 0, 1);
		batch.begin();

		for (ClientPlayer player : ClientGameManager.getPlayers()) {
			Vector3 pos = player.getPosition();
			batch.draw(green, pos.x, pos.y, 0, 0, Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT, 1, 1, pos.z, 0, 0, 1,
					1, false, false);
		}

		batch.end();

	}

	private void handleInput() {

		if (Gdx.input.isKeyPressed(Keys.W)) {
			sendKey(Keys.W);
		}
		if (Gdx.input.isKeyPressed(Keys.A)) {
			sendKey(Keys.A);

		}
		if (Gdx.input.isKeyPressed(Keys.S)) {
			sendKey(Keys.S);

		}
		if (Gdx.input.isKeyPressed(Keys.D)) {
			sendKey(Keys.D);

		}

	}

	public void sendKey(int keycode) {
		RequestUpdate update = new RequestUpdate();
		update.key = keycode;
		client.sendTCP(update);
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
