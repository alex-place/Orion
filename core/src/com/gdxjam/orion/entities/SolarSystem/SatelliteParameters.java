package com.gdxjam.orion.entities.SolarSystem;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.sun.xml.internal.stream.Entity;

public class SatelliteParameters {
	private Entity parent;
	private Vector2 startPosition;
	private Polygon polygon;
	private float distance, angelStep, angle, scale;
	
	public SatelliteParameters(Entity parent, Vector2 startPosition, Polygon polygon, float distance, float angelStep, float angle, float scale){
		this.parent = parent;
		this.startPosition = startPosition;
		this.distance = distance;
		this.angelStep = angelStep;
		this.angle = angle;
		this.scale = scale;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public float getAngelStep() {
		return angelStep;
	}

	public void setAngelStep(float angelStep) {
		this.angelStep = angelStep;
	}

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public Entity getParent() {
		return parent;
	}	
	public Polygon getPolygon() {
		return polygon;
	}

}
