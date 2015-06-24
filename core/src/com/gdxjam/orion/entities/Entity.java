package com.gdxjam.orion.entities;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public interface Entity {
	public void update(float delta);
	public Vector2 getPosition();

}
