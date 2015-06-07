package com.gdxjam.orion.screens;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
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
import com.gdxjam.orion.net.Network.RequestUpdateKey;
import com.gdxjam.orion.net.Network.RequestUpdateMouse;
import com.gdxjam.orion.utils.Constants;

public class ClientGameScreen implements Screen {

	private GameClient client;

	private OrthographicCamera camera;
	private SpriteBatch batch;

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
		camera.position.set(5, 5, 0);
		camera.update();
		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);

		green = new Texture(Gdx.files.internal("green.png"));

		DefaultInputHandler input = new DefaultInputHandler(client, camera);
		ClientGameManager.getInput().addProcessor(input);

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
			batch.draw(green, pos.x, pos.y, 1, 1);
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
		sendMouse(new Vector2(Gdx.input.getX(), Gdx.input.getY()));
	}

	private RequestUpdateKey updateKey;

	public void sendKey(int keycode) {
		updateKey = new RequestUpdateKey();
		updateKey.key = keycode;
		client.sendTCP(updateKey);
	}

	private RequestUpdateMouse updateMouse;

	public void sendMouse(Vector2 mosePos) {
		updateMouse = new RequestUpdateMouse();
		updateMouse.mousePos = mosePos;
		client.sendTCP(updateMouse);
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
