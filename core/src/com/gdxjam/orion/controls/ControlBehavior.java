package com.gdxjam.orion.controls;

import com.badlogic.gdx.math.Vector2;
import com.gdxjam.orion.entities.Player;
import com.gdxjam.orion.entities.ships.Ship;

public interface ControlBehavior {

	public void init(Ship ship);

	public void forwardDown(float delta);

	public void reverseDown(float delta);

	public void leftDown(float delta);

	public void rightDown(float delta);
	
	public void forwardUp(float delta);

	public void reverseUp(float delta);

	public void leftUp(float delta);

	public void rightUp(float delta);

	public void handleMouse(Vector2 position);

	public void handleClick(Vector2 position);

	public void handleKeyDown(int keycode);
	
	public void handleKeyUp(int keycode);

}
