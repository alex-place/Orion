package com.gdxjam.orion.entities;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public abstract class PolyEntity implements Entity {
	Polygon polygon;
	Vector2 position;

	public Polygon getPolygon(){
		return polygon;
	}
	public Vector2 getPosition(){
		return position;
	}
	
}
