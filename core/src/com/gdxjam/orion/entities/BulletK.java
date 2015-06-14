package com.gdxjam.orion.entities;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.utils.Pool.Poolable;
import com.badlogic.gdx.utils.TimeUtils;
import com.gdxjam.orion.GameManager;

public class BulletK extends Entity implements Poolable {
	private float lenght = 2;
	private float angle;
	private double lifeTime;
	private Body body;
	private Vector2 start;

	public BulletK(float angle, Vector2 start) {
		init(angle, start);
	}

	public BulletK() {
	}

	public void init(float angle, Vector2 start) {
		this.angle = angle;
		this.start = start;
		lifeTime = TimeUtils.millis() + 5000;
	}

	@Override
	public void reset() {
		destroy();
	}

	@Override
	public void destroy() {
		super.destroy();
		if (!GameManager.getWorld().isLocked()) {
			GameManager.getActive().removeValue(this, true);
			GameManager.getWorld().destroyBody(body);
		}
		body = null;
		start = null;
	}

	public boolean isReal() {
		return true;
	}

	@Override
	public void update(float delta) {
		super.update(delta);

		// System.out.println("Time to die is "+lifeTime+" The time is "+TimeUtils.millis());
		if (TimeUtils.millis() > lifeTime) {
			GameManager.getToBeDestroyed().add(this);
			;
		}
		body.setTransform(body.getPosition().x + (lenght * MathUtils.cos(angle)), body.getPosition().y + (lenght * MathUtils.sin(angle)), 0);

	}

	@Override
	public void add() {
		super.add();
		CircleShape circle = new CircleShape();
		circle.setRadius(0.1f);

		FixtureDef fixture = new FixtureDef();
		fixture.shape = circle;
		fixture.isSensor = true;
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.KinematicBody;
		bodyDef.position.set(start.x, start.y);
		body = GameManager.getWorld().createBody(bodyDef);
		body.createFixture(fixture);
	}
}
