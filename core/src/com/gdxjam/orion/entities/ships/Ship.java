package com.gdxjam.orion.entities.ships;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.controls.ControlBehavior;
import com.gdxjam.orion.utils.Constants;

public class Ship {

	private Body body;
	private FixtureDef fixture;
	private final float speed = 1.0f;
	private ControlBehavior behavior;

	public Ship(Vector3 position, ControlBehavior behavior) {
		this.behavior = behavior;

		PolygonShape rect = new PolygonShape();
		rect.setAsBox(Constants.PLAYER_HALFWIDTH, Constants.PLAYER_HALFHEIGHT);

		CircleShape circle = new CircleShape();
		circle.setRadius(Constants.PLAYER_HALFHEIGHT);

		fixture = new FixtureDef();
		// fixture.shape = rect;
		fixture.shape = circle;
		fixture.density = 1;
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(position.x, position.y);
		bodyDef.angle = position.z;
		bodyDef.angularDamping = Constants.ANGULAR_DAMPING;
		bodyDef.linearDamping = Constants.LINEAR_DAMPING;
		body = GameManager.getWorld().createBody(bodyDef);
		body.createFixture(fixture);
		body.setUserData(this);

	}

	public Body getBody() {
		return body;
	}

	public float getSpeed() {
		return speed;
	}

	public ControlBehavior getBehavior() {
		return behavior;
	}
}
