package com.gdxjam.orion.entities.SolarSystem;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.entities.PolyEntity;
import com.gdxjam.orion.utils.Shapes;

public class Astroids implements PolyEntity {
	Polygon polygon;
	Vector2 position, newPosition;
	float angle, speed;
	
	public Astroids(Vector2 position){
		this.position = position;
		newPosition = new Vector2(0, 0);
		
		angle = MathUtils.random(0, MathUtils.PI*2);
		speed = MathUtils.random(0.001f, 0.009f);
		
		polygon = new Polygon(Shapes.astroid(MathUtils.random(3, 5), 12));
		polygon.setPosition(position.x, position.y);
		GameManager.getActiveEntities().add(this);
	}
	public void update(float delta){
		newPosition.y += Math.sin(angle) * speed * delta;
		newPosition.x += Math.cos(angle) * speed * delta;
		
		position.y += newPosition.y;
		position.x += newPosition.x;
		
		polygon.setPosition(position.x, position.y);
		polygon.setRotation(polygon.getRotation() + 0.01f);
	}
	@Override
	public Polygon getPolygon() {
		return polygon;
	}
	@Override
	public Vector2 getPosition() {
		return position;
	}
}
