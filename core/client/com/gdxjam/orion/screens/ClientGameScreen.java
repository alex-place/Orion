package com.gdxjam.orion.screens;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.gdxjam.orion.Assets;
import com.gdxjam.orion.ClientGameManager;
import com.gdxjam.orion.entities.ClientPlayer;
import com.gdxjam.orion.input.DefaultInputHandler;
import com.gdxjam.orion.net.GameClient;
import com.gdxjam.orion.net.Network.RequestClick;
import com.gdxjam.orion.net.Network.RequestUpdateKey;
import com.gdxjam.orion.net.Network.RequestUpdateMouse;

public class ClientGameScreen implements Screen {

	private GameClient client;

	public OrthographicCamera cam;
	private SpriteBatch batch;

	private Texture green;

	FPSLogger fps;

	Color a, b, c, d;

	private Vector3 mouse;

	@Override
	public void show() {
		try {
			client = new GameClient();
		} catch (IOException e) {
			Gdx.app.exit();
			e.printStackTrace();
		}

		cam = new OrthographicCamera(10, 10);
		cam.position.set(5, 5, 0);
		cam.update();
		batch = new SpriteBatch();

		// green = new Texture(Gdx.files.internal("green.png"));

		fps = new FPSLogger();

		a = randomColor();
		b = randomColor();
		c = randomColor();
		d = randomColor();

		batch.setProjectionMatrix(cam.combined);

		DefaultInputHandler input = new DefaultInputHandler(client, cam);

		Gdx.input.setInputProcessor(input);

	}

	@Override
	public void render(float delta) {
		handleInput();
		client.update();
		batch.setProjectionMatrix(cam.combined);

		ClientPlayer id = ClientGameManager.getPlayers().get(ClientGameManager.getPlayer().id);
		cam.position.set(id.position.x, id.position.y, 0);
		cam.update();

		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl20.glClearColor(0, 0, 0, 1);
		batch.begin();

		for (ClientPlayer player : ClientGameManager.getPlayers().values()) {
			if (player.id == 0) {
				batch.setColor(a);
			}
			if (player.id == 1) {
				batch.setColor(b);
			}
			if (player.id == 2) {
				batch.setColor(c);
			}
			if (player.id == 3) {
				batch.setColor(d);
			}

			batch.draw(Assets.square.reg, player.position.x, player.position.y, 1, 1);
			batch.setColor(0, 0, 0, 1);
		}
		batch.end();

	}

	public Color randomColor() {
		return new Color(MathUtils.random(), MathUtils.random(), MathUtils.random(), 1);
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
		handleMouseMove();
		handleMouseClick();
	}

	private RequestUpdateKey updateKey;

	public void sendKey(int keycode) {
		updateKey = new RequestUpdateKey();
		updateKey.key = keycode;
		client.sendTCP(updateKey);
	}

	private RequestUpdateMouse updateMouse;

	public void handleMouseMove() {

		if (Gdx.input.getX() == Gdx.input.getDeltaX() && Gdx.input.getY() == Gdx.input.getDeltaY()) {
			return;
			// Mouse didn't move
		} else {
			updateMouse = new RequestUpdateMouse();
			mouse = cam.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
			updateMouse.mousePos = new Vector2(mouse.x, mouse.y);
			mouse = null;
			client.sendTCP(updateMouse);
		}
	}

	private RequestClick requestClick;

	public void handleMouseClick() {
		if (!Gdx.input.isTouched()) {
			return;
		}

		requestClick = new RequestClick();

		if (Gdx.input.isButtonPressed(Buttons.LEFT)) {
			requestClick.left = true;
		}

		if (Gdx.input.isButtonPressed(Buttons.LEFT)) {
			requestClick.right = true;
		}

		mouse = cam.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
		requestClick.mousePos = new Vector2(mouse.x, mouse.y);
		mouse = null;
		client.sendTCP(requestClick);

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
		batch.dispose();
		green.dispose();

	}

}
