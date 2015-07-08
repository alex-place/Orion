package com.gdxjam.orion.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public interface PolyEntity extends Entity {
	public Polygon getPolygon();
}
