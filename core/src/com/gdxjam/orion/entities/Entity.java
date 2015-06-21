package com.gdxjam.orion.entities;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {
	private Polygon poly;
	private Vector2 position;
	
	public Polygon getPolygon(){
		return poly;
	}
	public void update(float delta){
		
	}
	public Vector2 getPosition() {
		return position;
	}
}
