package com.gdxjam.orion.entities;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.controls.ControlBehavior;
import com.gdxjam.orion.utils.Constants;

public class Player extends Entity {

	private Body body;
	private final int id;
	private final float speed = 1.0f;
	private ControlBehavior behavior;

	public Player(Vector3 position, int id, ControlBehavior behavior) {
		this.id = id;
		this.behavior = behavior;
		PolygonShape rect = new PolygonShape();
		rect.setAsBox(Constants.PLAYER_HALFWIDTH, Constants.PLAYER_HALFHEIGHT);
		FixtureDef fixture = new FixtureDef();
		fixture.shape = rect;
		fixture.density = 1;
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(position.x, position.y);
		bodyDef.angle = position.z;
		bodyDef.angularDamping = Constants.ANGULAR_DAMPING;
		bodyDef.linearDamping = Constants.LINEAR_DAMPING;
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

	public float getSpeed() {
		return speed;
	}

	public float getOrientation() {
		return body.getAngle();

	}

}
