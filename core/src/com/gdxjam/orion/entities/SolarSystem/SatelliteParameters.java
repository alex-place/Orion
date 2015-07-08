package com.gdxjam.orion.entities.SolarSystem;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.entities.Entity;
import com.gdxjam.orion.utils.Shapes;

public class SatelliteParameters {
	public Entity parent;
	public Vector2 startPosition;
	public Polygon polygon;
	public float distance, angelStep, angle;
	
	public SatelliteParameters(Entity parent, float distance, float angelStep, float angle, float scale){
		this.parent = parent;
		this.startPosition = startPosition;
		this.distance = distance;
		this.angelStep = angelStep;
		this.angle = angle;
		
		polygon = new Polygon(Shapes.circle(scale, 12));
	}

}
