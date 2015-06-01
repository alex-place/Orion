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

	OrthographicCamera camera;
	World world;
	Box2DDebugRenderer renderer = new Box2DDebugRenderer();

	@Override
	public void show() {
		camera = new OrthographicCamera(10, 10);
		world = new World(new Vector2(0, 0), true);
		renderer = new Box2DDebugRenderer();

		for (int x = 0; x < 2; x++) {
			CircleShape circle = new CircleShape();
			circle.setRadius(1);
			FixtureDef fixture = new FixtureDef();
			fixture.shape = circle;
			fixture.density = 1;
			BodyDef bodyDef = new BodyDef();
			bodyDef.type = BodyType.StaticBody;
			Body body = world.createBody(bodyDef);
			body.createFixture(fixture);
			body.setTransform(0, x * 2, 0);
		}

		for (int x = 1; x < 100; x++) {
			CircleShape circle = new CircleShape();
			circle.setRadius(1);
			FixtureDef fixture = new FixtureDef();
			fixture.shape = circle;
			fixture.density = 1;
			fixture.isSensor = true;
			BodyDef bodyDef = new BodyDef();
			bodyDef.type = BodyType.StaticBody;
			Body body = world.createBody(bodyDef);
			body.createFixture(fixture);
			body.setTransform(x * 0.03f, 1, 0);
		}

	}

	@Override
	public void render(float delta) {
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl20.glClearColor(0, 0, 0, 1);
		renderer.render(world, camera.combined);

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
