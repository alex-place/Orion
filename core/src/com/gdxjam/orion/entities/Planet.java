package com.gdxjam.orion.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.utils.Constants;

public class Planet extends Entity {
	private Body body;
	private FixtureDef fixture;

	private float angle = 0.0f;
	private float orabitSpeed = MathUtils.random()*0.01f;
	
	public Planet(Vector2 position, float radius){
		init(position, radius);
	}

	public void init(Vector2 position, float radius) {
		CircleShape circle = new CircleShape();
		circle.setRadius(radius);

		fixture = new FixtureDef();
		fixture.shape = circle;
		fixture.density = 1;
		fixture.isSensor = true;

		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.KinematicBody;
		bodyDef.position.set(position.x, position.y);
		body = GameManager.getWorld().createBody(bodyDef);
		body.createFixture(fixture);
		body.setUserData(this);

	}

	public void update(float delta){
		angle += orabitSpeed;

		float x = MathUtils.cos(angle) * (body.getPosition().x - Constants.WORLD_WIDTH/2) - MathUtils.sin(angle) * (body.getPosition().y - Constants.WORLD_HEIGHT/2) + Constants.WORLD_WIDTH/2;
		float y = MathUtils.sin(angle) * (body.getPosition().x - Constants.WORLD_WIDTH/2) + MathUtils.cos(angle) * (body.getPosition().y - Constants.WORLD_HEIGHT/2) + Constants.WORLD_HEIGHT/2;
		Gdx.app.log("planet", "x: "+x+" y "+y);
		body.setTransform(x, y, body.getAngle()+0.001f);
		if(angle <= MathUtils.PI*2){
			angle = 0;
		}

	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

}
