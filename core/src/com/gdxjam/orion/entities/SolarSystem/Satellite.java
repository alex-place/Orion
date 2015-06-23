package com.gdxjam.orion.entities.SolarSystem;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.entities.Entity;

public class Satellite extends Entity{
	private Polygon poly; 
	private Vector2 position;
	private Entity parent;
	private float distance, angle, angelStep = 0.01f;
	
	public Satellite(Polygon poly, Entity parent, float distance){
		this.position = new Vector2(0,0);
		this.poly = poly;
		this.parent = parent;
		this.distance = distance;
		poly.setPosition(position.x, position.y);
		
	}
	public void update(float delta){
		super.update(delta);
		if (angle > MathUtils.PI*2){ angle = 0;}

		   // rotatedX = Math.cos(angle) * (point.x - center.x) - Math.sin(angle) * (point.y-center.y) + center.x;
		position.x = MathUtils.cos(angle) * ((parent.getPosition().x + distance) - parent.getPosition().x) - MathUtils.sin(angle) * ((parent.getPosition().y + distance) - parent.getPosition().y) + parent.getPosition().x;
		 
		   // rotatedY = Math.sin(angle) * (point.x - center.x) + Math.cos(angle) * (point.y - center.y) + center.y;
		position.y = MathUtils.sin(angle) * ((parent.getPosition().x + distance) - parent.getPosition().x) + MathUtils.cos(angle) * ((parent.getPosition().y + distance) - parent.getPosition().y) + parent.getPosition().y;
		
		poly.setPosition(position.x, position.y);
		angle += angelStep;
		
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
