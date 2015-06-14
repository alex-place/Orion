package com.gdxjam.orion.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
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
		Vector3 mos = camera.unproject(new Vector3(screenX, screenY, 0));
		camera.position.set(mos);
		camera.update();

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

		int zoomScale = 100;

		if (amount > 0) {
			zoom += zoomScale;
		}

		// Zoom in
		if (amount < 0) {
			zoom -= zoomScale;
		}

		if (zoom < 0) {
			zoom = 0;
		}

		if (zoom > 1000) {
			zoom = 1000;
		}

		Gdx.app.log("Zoom", zoom + "");

		camera.zoom = zoom;
		camera.update();

		return false;
	}
}
