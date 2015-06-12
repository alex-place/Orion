package com.gdxjam.orion.entities;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Joint;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.utils.RevoluteJoint;

public class Sattelite extends Entity {

	private Body body;

	public Sattelite(SatteliteParameters p) {
		init(p);
	}

	public Sattelite(float distance, float radius, Entity parent) {
		SatteliteParameters p = new SatteliteParameters();
		p.distanceFromOrigin = 5;
		p.radius = radius;
		p.parent = parent;
		p.speed = 360;
		p.torque = 10;
		init(p);
	}

	public void init(SatteliteParameters p) {
		CircleShape circle = new CircleShape();
		circle.setRadius(p.radius);

		FixtureDef fixture = new FixtureDef();
		fixture.shape = circle;
		fixture.density = p.density;
		fixture.isSensor = true;

		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(p.parent.getBody().getPosition().x + p.distanceFromOrigin, p.parent.getBody().getPosition().y);
		body = GameManager.getWorld().createBody(bodyDef);
		body.createFixture(fixture);
		body.setUserData(this);
		//body.setLinearDamping(0.001f);

		RevoluteJoint j = new RevoluteJoint(p.parent.getBody(), body, true);
		j.setAnchorA(0, 0);
		j.setAnchorB(p.distanceFromOrigin, 0);
		j.setMotor(p.speed, p.torque);

		Joint joint = j.createJoint(GameManager.getWorld());

	}

	@Override
	public void update(float delta) {
		super.update(delta);
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public static class SatteliteParameters {
		public Entity parent;

		public float radius;
		public float distanceFromOrigin;
		public float speed;
		public float torque;
		public float density;

		public SatteliteParameters() {
		}

		public SatteliteParameters(Entity parent, float radius, float distanceFromOrigin, float speed, float torque, float density) {
			this.parent = parent;
			this.radius = radius;
			this.distanceFromOrigin = distanceFromOrigin;
			this.speed = speed;
			this.torque = torque;
			this.density = density;
		}

	}

}
