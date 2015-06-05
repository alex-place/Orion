package com.gdxjam.orion.controls;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.gdxjam.orion.entities.Player;

public interface ControlBehavior {

	public void init(Player player);

	public void forward(float delta);

	public void reverse(float delta);

	public void left(float delta);

	public void right(float delta);

	public void lookAt(Vector2 position);

	public void handleKey(int keycode);

	public void fire(Vector2 position);

}
