package com.gdxjam.orion.entities.SolarSystem;

import com.sun.xml.internal.stream.Entity;

public class SolarSystemParameters {
	private Entity parent;
	private float distance, angelStep, angle, scale;
	
	public SolarSystemParameters(Entity parent, float distance, float angelStep, float angle, float scale){
		this.parent = parent;
		this.distance = distance;
		this.angelStep = angelStep;
		this.angle = angle;
		this.scale = scale;
	}

}
