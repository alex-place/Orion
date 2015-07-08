package com.gdxjam.orion.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

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

		switch (keycode) {
		case Keys.SPACE:
			camera.position.set(0, 0, 0);
			camera.update();
			break;
		default:
			break;
		}

		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (button == Buttons.LEFT) {
			Vector3 mos = camera.unproject(new Vector3(screenX, screenY, 0));
			camera.position.set(mos);
			camera.update();
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// Zoom out

		int zoomScale = 1;

		// Zoom in
		if (amount < 0) {
			zoom -= zoomScale;
		} else

		if (amount > 0) {
			zoom += zoomScale;
		}

		if (zoom < 1) {
			zoom = 1;
		} else

		if (zoom > 75) {
			zoom = 75;
		}

		Gdx.app.log("Zoom", zoom + "");

		camera.zoom = zoom;
		camera.update();

		return false;
	}
}
