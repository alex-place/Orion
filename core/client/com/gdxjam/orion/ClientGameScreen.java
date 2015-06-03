package com.gdxjam.orion;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class ClientGameScreen implements Screen {

	private GameClient client;
	private ClientPlayer player;

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

		player = ClientGameManager.getPlayer();

		camera = new OrthographicCamera(10, 10);
		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);

		input = new DefaultInputHandler(client);
		Gdx.input.setInputProcessor(input);

		green = new Texture(Gdx.files.internal("green.png"));

	}

	@Override
	public void render(float delta) {
		client.update();
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl20.glClearColor(0, 0, 0, 1);
		batch.begin();

		for (ClientPlayer player : ClientGameManager.getPlayers()) {
			Vector3 pos = player.getPosition();
			batch.draw(green, pos.x, pos.y, 0, 0, 1, 1, 1, 1, pos.z, 0, 0, 1,
					1, false, false);
		}

		batch.end();

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
