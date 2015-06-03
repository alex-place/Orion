package com.gdxjam.orion;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class Player extends Entity {

	private Body body;
	private final int id;

	public Player(Vector2 position, int id) {
		this.id = id;

		CircleShape circle = new CircleShape();
		circle.setRadius(1);
		FixtureDef fixture = new FixtureDef();
		fixture.shape = circle;
		fixture.density = 1;
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(position);
		body = GameManager.getWorld().createBody(bodyDef);
		body.createFixture(fixture);
		// body.setTransform(position, 0);

		GameManager.getPlayers().put(id, this);
	}

	public Player(int x, int y, int id) {
		this(new Vector2(x, y), id);
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public int getId() {
		return id;
	}

	public void up() {
		body.applyForceToCenter(new Vector2(1000, 1000), true);
		System.out.println("GOING UP IN THE CLUB ON A TUESDAY!");
	}
}
