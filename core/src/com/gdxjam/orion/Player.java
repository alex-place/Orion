package com.gdxjam.orion;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class Player extends Entity {

	Body body;
	int id;

	public Player(Vector2 position, int id) {
		this.id = id;

		CircleShape circle = new CircleShape();
		circle.setRadius(1);
		FixtureDef fixture = new FixtureDef();
		fixture.shape = circle;
		fixture.density = 1;
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.StaticBody;
		bodyDef.position.set(position);
		Body body = GameManager.getWorld().createBody(bodyDef);
		body.createFixture(fixture);
		// body.setTransform(position, 0);

		GameManager.getPlayers().add(this);
	}

	public Player(int x, int y, int id) {
		this(new Vector2(x, y), id);
	}
}
