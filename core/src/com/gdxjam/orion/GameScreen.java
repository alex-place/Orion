package com.gdxjam.orion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public class GameScreen implements Screen {

	/**
	 * Keep in mind this will be discarded on switching to headless
	 * */
	Box2DDebugRenderer renderer = new Box2DDebugRenderer();
	OrthographicCamera camera;

	@Override
	public void show() {
		camera = new OrthographicCamera(100, 100);
		renderer = new Box2DDebugRenderer();
		Player player = new Player(1, 1, 0);

	}

	@Override
	public void render(float delta) {

		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl20.glClearColor(0, 0, 0, 1);
		renderer.render(GameManager.getWorld(), camera.combined);
		update();

	}

	private void update() {
		GameManager.getWorld().step(1 / 60f, 6, 2);
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
