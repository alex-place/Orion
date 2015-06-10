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
	private float speed = 5;
	private Body body;
	private Vector2 start;

	public Bullet() {
	}

	public void init(Vector2 start, Vector2 target) {
		this.start = start;
		CircleShape circle = new CircleShape();
		circle.setRadius(0.1f);

		FixtureDef fixture = new FixtureDef();
		fixture.shape = circle;
		fixture.density = 1;
		fixture.isSensor = true;
		// fixture.isSensor = false;
		BodyDef bodyDef = new BodyDef();
		// bodyDef.bullet = true;
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(start.x, start.y);
		bodyDef.angularDamping = Constants.ANGULAR_DAMPING;
		// bodyDef.linearDamping = Constants.LINEAR_DAMPING;
		body = GameManager.getWorld().createBody(bodyDef);
		body.createFixture(fixture);

		Vector2 angle = new Vector2();
		angle = start.sub(target).nor();
		angle.scl(speed);
		angle.rotate(180);

		body.applyForceToCenter(angle, true);
		body.setUserData(this);
	}

	@Override
	public void reset() {
		destroy();
	}

	@Override
	public void destroy() {
		super.destroy();
		GameManager.getActive().removeValue(this, true);
		GameManager.getWorld().destroyBody(body);
		body = null;
		start = null;
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		if (Math.abs(body.getPosition().dst(start)) > 1) {
			System.out.println("Destroy me!");
			GameManager.getToBeDestroyed().add(this);
		}
	}
}
