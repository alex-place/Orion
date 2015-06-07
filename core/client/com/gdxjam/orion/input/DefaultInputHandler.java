package com.gdxjam.orion.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.net.GameClient;
import com.gdxjam.orion.net.Network.RequestUpdateKey;

public class DefaultInputHandler implements InputProcessor {

	private GameClient client;
	private OrthographicCamera camera;

	public DefaultInputHandler(GameClient client, OrthographicCamera camera) {
		this.client = client;
		this.camera = camera;
	}

	@Override
	public boolean keyDown(int keycode) {
		Gdx.app.log("balls", "ass");
		switch (keycode) {

		case Keys.ESCAPE:
			Gdx.app.exit();
			break;

		default:
			RequestUpdateKey update = new RequestUpdateKey();
			update.key = keycode;

			client.sendTCP(update);
			break;
		}

		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		RequestUpdateKey update = new RequestUpdateKey();
		update.mousePos = new Vector2(screenX, screenY);
		client.sendTCP(update);
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
