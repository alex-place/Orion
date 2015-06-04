package com.gdxjam.orion;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.gdxjam.orion.controls.ControlBehavior;

public class Player extends Entity {

	private Body body;
	private final int id;
	private final int speed = 100;
	private ControlBehavior behavior;

	public Player(Vector3 position, int id, ControlBehavior behavior) {
		this.id = id;
		this.behavior = behavior;

		CircleShape circle = new CircleShape();
		circle.setRadius(1);
		FixtureDef fixture = new FixtureDef();
		fixture.shape = circle;
		fixture.density = 1;
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(position.x, position.y);
		bodyDef.angle = position.z;
		body = GameManager.getWorld().createBody(bodyDef);
		body.createFixture(fixture);

		GameManager.getPlayers().put(id, this);
	}

	public Player(int x, int y, int rotation, int id, ControlBehavior behavior) {
		this(new Vector3(x, y, rotation), id, behavior);
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

	public ControlBehavior getBehavior() {
		return behavior;
	}

	public int getSpeed() {
		return speed;
	}

}
