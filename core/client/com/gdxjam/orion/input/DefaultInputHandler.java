package com.gdxjam.orion.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.gdxjam.orion.net.GameClient;
import com.gdxjam.orion.net.Network.RequestClick;
import com.gdxjam.orion.net.Network.RequestUpdate;

public class DefaultInputHandler implements InputProcessor {

	private GameClient client;
	private OrthographicCamera camera;

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
			RequestUpdate update = new RequestUpdate();
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
		if (pointer == Buttons.LEFT) {
			Vector3 position = camera.unproject(new Vector3(screenX, screenY, 0));
			RequestClick request = new RequestClick();
			request.position = new Vector2(position.x, position.y);
			client.sendTCP(request);
		}

		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {

		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
