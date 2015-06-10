package com.gdxjam.orion.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.entities.Bullet;
import com.gdxjam.orion.entities.Planet;
import com.gdxjam.orion.entities.Sun;

public class EntityFactory {

	static int locked = 0;
	static int unlocked = 0;

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

	public static void createBullet(Vector2 start, Vector2 target) {
		Bullet bullet;
		if (!GameManager.getWorld().isLocked()) {
			bullet = GameManager.getBullets().obtain();
			bullet.init(start, target);
			unlocked++;
		} else {
			bullet = GameManager.getBullets().obtain();
			bullet.init(start, target);
			GameManager.getToBeAdded().add(bullet);

			locked++;
		}
		Gdx.app.log("Is it locking?", " locked: " + locked + " unlocked: " + unlocked);
	}
	public static void createSun(){
		new Sun(new Vector2(Constants.WORLD_WIDTH/2, Constants.WORLD_HEIGHT/2));
		
	}
	public static void createPlanet(float radius, Vector2 position){

		new Planet(position, radius);
	}

}
