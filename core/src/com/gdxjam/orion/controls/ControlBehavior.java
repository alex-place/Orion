package com.gdxjam.orion.controls;

import com.badlogic.gdx.math.Vector2;

public interface ControlBehavior {

	public void forward();

	public void reverse();

	public void left();

	public void right();

	public void lookAt(Vector2 position);

}
