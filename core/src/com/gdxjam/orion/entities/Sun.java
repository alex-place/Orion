package com.gdxjam.orion.entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.controls.ControlBehavior;
import com.gdxjam.orion.utils.Constants;

public class Sun extends Entity{
	private Body body;
	private FixtureDef fixture;
	private ControlBehavior behavior;
	
	public Sun(Vector2 position){
		init(position);
	}
	
	public void init(Vector2 position) {
		this.behavior = behavior;

		CircleShape circle = new CircleShape();
		circle.setRadius(10);

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
	public static void update(){
		
	}
	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public ControlBehavior getBehavior() {
		return behavior;
	}

}
