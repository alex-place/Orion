package com.gdxjam.orion.entities.SolarSystem;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.GameManager;
import com.gdxjam.orion.entities.PolyEntity;
import com.gdxjam.orion.utils.Constants;
import com.gdxjam.orion.utils.Shapes;

public class World implements PolyEntity {
	Polygon polygon;
	Vector2 position;
	
	public World(){
		position = new Vector2(0,0);
		polygon = new Polygon(Shapes.square(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT));
		polygon.setPosition(position.x, position.y);
		GameManager.getActiveEntities().add(this);
	}
	
	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}
	public Polygon getPolygon(){

		return polygon;
	}

	@Override
	public Vector2 getPosition() {
		// TODO Auto-generated method stub
		return position;
	}

}
