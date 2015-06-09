package com.gdxjam.orion;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.gdxjam.orion.entities.Bullet;
import com.gdxjam.orion.entities.Entity;

public class WorldContactListener implements ContactListener {

	@Override
	public void beginContact(Contact contact) {

		Entity entityA = (Entity) contact.getFixtureA().getUserData();
		Entity entityB = (Entity) contact.getFixtureA().getUserData();

//		if (entityA instanceof Bullet) {
//			GameManager.getBullets().free((Bullet) entityA);
//		}
//
//		if (entityB instanceof Bullet) {
//			GameManager.getBullets().free((Bullet) entityB);
//		}

	}

	@Override
	public void endContact(Contact contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub

	}

}
