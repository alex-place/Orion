package com.gdxjam.orion.entities.SolarSystem;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.entities.Entity;
import com.gdxjam.orion.entities.PolyEntity;

public class Satellite extends PolyEntity{
	SatelliteParameters p;
	private float angle;
	Vector2 position = new Vector2(0,0);
	
	public Satellite(SatelliteParameters p){
		this.p = p;
	}
	public void update(float delta){

		if (angle > MathUtils.PI*2){ angle = 0;}

		   // rotatedX = Math.cos(angle) * (point.x - center.x) - Math.sin(angle) * (point.y-center.y) + center.x;
		position.x = MathUtils.cos(angle) * ((p.parent.getPosition().x + p.distance) - p.parent.getPosition().x) - 
				MathUtils.sin(angle) * ((p.parent.getPosition().y + p.distance) - p.parent.getPosition().y) + p.parent.getPosition().x;
		 
		   // rotatedY = Math.sin(angle) * (point.x - center.x) + Math.cos(angle) * (point.y - center.y) + center.y;
		position.y = MathUtils.sin(angle) * ((p.parent.getPosition().x + p.distance) - p.parent.getPosition().x) + 
				MathUtils.cos(angle) * ((p.parent.getPosition().y + p.distance) - p.parent.getPosition().y) + p.parent.getPosition().y;
		
		p.polygon.setPosition(position.x, position.y);
		angle += p.angelStep;
		
	}
	public Polygon getPolygon() {
		return p.polygon;
	}
	public Vector2 getPosition() {
		return position;
	}
	public void setPosition(Vector2 position) {
		this.position = position;
	}
}
