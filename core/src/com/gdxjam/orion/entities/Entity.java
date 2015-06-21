package com.gdxjam.orion.entities;

import com.badlogic.gdx.math.Polygon;

public abstract class Entity {
	private Polygon poly;
	
	public Polygon getPolygon(){
		return poly;
	}
	public void update(float delta){
		
	}
}
