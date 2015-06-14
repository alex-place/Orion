package com.gdxjam.orion.entities;

import javafx.scene.Parent;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Joint;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.utils.RevoluteJoint;

public class Sattelite1 extends Entity {

	private Body body;
	SatteliteParameters1 p;

	public Sattelite1(SatteliteParameters1 p) {
		this.p = p;
		init(p);
	}

	public void init(SatteliteParameters1 p) {
		CircleShape circle = new CircleShape();
		circle.setRadius(p.radius);

		FixtureDef fixture = new FixtureDef();
		fixture.shape = circle;
		fixture.isSensor = true;

		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.KinematicBody;
		bodyDef.position.set(p.parent.getBody().getPosition().x + p.distanceFromOrigin, p.parent.getBody().getPosition().y);
		body = GameManager.getWorld().createBody(bodyDef);
		body.createFixture(fixture);
		body.setUserData(this);


	}

	@Override
	public void update(float delta) {
		super.update(delta);
		if(p.angle > MathUtils.PI*2){p.angle = 0;}
		if(p.angle < 0){p.angle = p.angle + MathUtils.PI*2;}

		
		body.setTransform(
				MathUtils.cos(p.angle) * ((p.parent.getBody().getPosition().x + p.distanceFromOrigin) - p.parent.getBody().getPosition().x) - 
				 MathUtils.sin(p.angle) * ((p.parent.getBody().getPosition().y + p.distanceFromOrigin) - p.parent.getBody().getPosition().y) + p.parent.getBody().getPosition().x,
				 
				 MathUtils.sin(p.angle) * ((p.parent.getBody().getPosition().x + p.distanceFromOrigin) - p.parent.getBody().getPosition().x) +
		         MathUtils.cos(p.angle) * ((p.parent.getBody().getPosition().y + p.distanceFromOrigin) - p.parent.getBody().getPosition().y) + p.parent.getBody().getPosition().y, 0);
		
		p.angle += p.angelStep;
		
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public static class SatteliteParameters1 {
		public Entity parent;

		public float radius;
		public float distanceFromOrigin;
		public float angelStep;
		public float angle;

		public SatteliteParameters1(Entity parent, float radius, float distanceFromOrigin, float angelStep, float angle) {
			this.parent = parent;
			this.radius = radius;
			this.distanceFromOrigin = distanceFromOrigin;
			this.angelStep = angelStep;
			this.angle = angle;
		}

	}

}
