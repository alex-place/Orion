package com.gdxjam.orion.entities.SolarSystem;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.entities.Entity;
import com.gdxjam.orion.entities.PolyEntity;
import com.gdxjam.orion.utils.Shapes;

public class Sun implements PolyEntity {
	Polygon polygon;
	private Vector2 position;

	public Sun(Vector2 position){
		this.position = position;
		polygon = new Polygon(Shapes.circle(100, 16));
		polygon.setPosition(position.x, position.y);
		GameManager.getActiveEntities().add(this);
		
	}
	public void update(){
		
	}
	public Polygon getPolygon() {
		return polygon;
	}
	public Vector2 getPosition() {
		return position;
	}
	public void setPosition(Vector2 position) {
		this.position = position;
	}
	@Override
	public void update(float delta) {
		
	}
}
