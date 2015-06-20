package com.gdxjam.orion.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.gdxjam.orion.net.GameClient;
import com.gdxjam.orion.net.Network.RequestUpdateKey;
import com.gdxjam.orion.net.Network.RequestUpdateMouse;

public class DefaultInputHandler implements InputProcessor {

	private GameClient client;
	private OrthographicCamera camera;
	private float zoom;

	public DefaultInputHandler(GameClient client, OrthographicCamera camera) {
		this.client = client;
		this.camera = camera;
	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
		case Keys.ESCAPE:
			Gdx.app.exit();
			break;

		default:
			RequestUpdateKey update = new RequestUpdateKey();
			update.keyDown = keycode;
			client.sendTCP(update);
			break;
		}

		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		RequestUpdateKey update = new RequestUpdateKey();
		update.keyUp = keycode;
		client.sendTCP(update);
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
		RequestUpdateMouse update = new RequestUpdateMouse();
		Vector3 pos = camera.unproject(new Vector3(screenX, screenY, 0));
		update.mousePos = new Vector2(pos.x, pos.y);
		client.sendTCP(update);
		return false;
	}

	@Override
	public boolean scrolled(int amount) {

		if (amount > 0) {
			zoom += 0.1f;
		}

		// Zoom in
		if (amount < 0) {
			zoom -= 0.1f;
		}
		camera.zoom = zoom;
		camera.update();

		return false;
	}

}
