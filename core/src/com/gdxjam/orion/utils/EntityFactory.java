package com.gdxjam.orion.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.gdxjam.orion.GameManager;

public class EntityFactory {

	public static void createBoundry(Vector2 start, Vector2 end) {
		FixtureDef def = new FixtureDef();
		EdgeShape edge = new EdgeShape();
		edge.set(start, end);
		def.shape = edge;
		def.isSensor = true;

		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.StaticBody;
		bodyDef.position.set(start);

		GameManager.getWorld().createBody(bodyDef).createFixture(edge, 1.0f);
	}

}
