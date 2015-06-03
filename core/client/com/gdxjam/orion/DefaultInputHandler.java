package com.gdxjam.orion;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.gdxjam.orion.net.Network.RequestUpdate;

public class DefaultInputHandler implements InputProcessor {

	private GameClient client;

	public DefaultInputHandler(GameClient client) {
		this.client = client;
	}

	@Override
	public boolean keyDown(int keycode) {

		switch (keycode) {
		case Keys.W:
		case Keys.A:
		case Keys.S:
		case Keys.D:
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
