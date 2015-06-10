package com.gdxjam.orion.input;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class DevInputProcessor implements InputProcessor {

	OrthographicCamera camera;
	float zoom = 1.0f;

	public DevInputProcessor(OrthographicCamera camera) {
		this.camera = camera;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
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
		// Zoom out
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
