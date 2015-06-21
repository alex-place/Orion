package com.gdxjam.orion.entities;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public class Sun extends Entity{
	private Polygon poly; 
	private Vector2 position;
	public Sun(Polygon poly, Vector2 position){
		this.position = position;
		this.poly = poly;
		poly.setPosition(position.x, position.y);
		
	}
	public void update(){
		
	}
	public Polygon getPolygon() {
		return poly;
	}
	public Vector2 getPosition() {
		return position;
	}
	public void setPosition(Vector2 position) {
		this.position = position;
	}
}
