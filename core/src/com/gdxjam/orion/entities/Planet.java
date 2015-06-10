package com.gdxjam.orion.entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.utils.Constants;

public class Planet extends Entity {
	private Body body;
	private FixtureDef fixture;
	float angle = 0.0f;

	public Planet(Vector2 position, float radius) {
		init(position, radius);
	}

	public void init(Vector2 position, float radius) {
		CircleShape circle = new CircleShape();
		circle.setRadius(radius);

		fixture = new FixtureDef();
		fixture.shape = circle;
		fixture.density = 1;
		fixture.isSensor = true;

		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.KinematicBody;
		bodyDef.position.set(position.x, position.y);
		body = GameManager.getWorld().createBody(bodyDef);
		body.createFixture(fixture);
		body.setUserData(this);

	}

	public void update() {
		angle += 1;
		float x = (float) (Math.cos(angle) * (body.getPosition().x - Constants.WORLD_WIDTH / 2) - Math.sin(angle)
				* (body.getPosition().y - Constants.WORLD_HEIGHT / 2) + Constants.WORLD_WIDTH / 2);
		float y = (float) (Math.sin(angle) * (body.getPosition().x - Constants.WORLD_WIDTH / 2) - Math.cos(angle)
				* (body.getPosition().y - Constants.WORLD_HEIGHT / 2) + Constants.WORLD_HEIGHT / 2);
		body.setTransform(x, y, 0);
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

}
