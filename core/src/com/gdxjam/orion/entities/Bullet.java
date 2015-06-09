package com.gdxjam.orion.entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.utils.Pool.Poolable;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.utils.Constants;

public class Bullet extends Entity implements Poolable {
	float speed = 5;
	public boolean flagged = false;

	public Bullet() {
	}

	public void init(Vector2 start, Vector2 target) {
		CircleShape circle = new CircleShape();
		circle.setRadius(0.1f);

		FixtureDef fixture = new FixtureDef();
		fixture.shape = circle;
		fixture.density = 1;
		fixture.isSensor = true;
		// fixture.isSensor = false;
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(start.x, start.y);
		bodyDef.angularDamping = Constants.ANGULAR_DAMPING;
		// bodyDef.linearDamping = Constants.LINEAR_DAMPING;
		if (!GameManager.getWorld().isLocked()) {
			Body body = GameManager.getWorld().createBody(bodyDef);
			body.createFixture(fixture);

			Vector2 angle = new Vector2();
			angle = start.sub(target).nor();
			angle.scl(speed);
			angle.rotate(180);

			body.applyForceToCenter(angle, true);
			body.setUserData(this);
		}
	}

	@Override
	public void reset() {
		// System.out.println("There trying to destroy me!!!");
		// for (Fixture fixture : body.getFixtureList()) {
		// body.destroyFixture(fixture);
		// }
		// body.setUserData(null);
		// GameManager.getWorld().destroyBody(body);
	}

}
