package com.gdxjam.orion.utils;

import com.badlogic.gdx.math.MathUtils;

public class Shapes {
	public final static float scale = 9;
	public final static float[] CIRCLE = { 0.22222222f, 0.0f, 0.33333334f,
			0.0f, 0.44444445f, 0.0f, 0.5555556f, 0.0f, 0.6666667f, 0.0f,
			0.7777778f, 0.11111111f, 0.8888889f, 0.22222222f, 0.8888889f,
			0.33333334f, 0.8888889f, 0.44444445f, 0.8888889f, 0.5555556f,
			0.8888889f, 0.6666667f, 0.7777778f, 0.7777778f, 0.6666667f,
			0.8888889f, 0.5555556f, 0.8888889f, 0.44444445f, 0.8888889f,
			0.33333334f, 0.8888889f, 0.22222222f, 0.8888889f, 0.11111111f,
			0.7777778f, 0.0f, 0.6666667f, 0.0f, 0.5555556f, 0.0f, 0.44444445f,
			0.0f, 0.33333334f, 0.0f, 0.22222222f, 0.11111111f, 0.11111111f };

	public final static float[] ACUTE_TRIANGLE_DOWN = { 0.44444445f, 0.0f,
			0.8888889f, 0.8888889f, 0.0f, 0.8888889f };

	public final static float[] DIAMOND = { 0.44444445f, 0.0f, 0.5555556f,
			0.11111111f, 0.6666667f, 0.22222222f, 0.7777778f, 0.33333334f,
			0.8888889f, 0.44444445f, 0.7777778f, 0.5555556f, 0.6666667f,
			0.6666667f, 0.5555556f, 0.7777778f, 0.44444445f, 0.8888889f,
			0.33333334f, 0.7777778f, 0.22222222f, 0.6666667f, 0.22222222f,
			0.5555556f, 0.0f, 0.44444445f, 0.11111111f, 0.33333334f,
			0.22222222f, 0.22222222f, 0.33333334f, 0.11111111f };
	
	public static float[] circle(float radius, int sections){
		float angleStep = (MathUtils.PI*2)/sections, angle = 0;
		float[] shape = new float[sections*2];
		
		for(int i = 0; i < sections*2; i += 2){
			shape[i] = MathUtils.cos(angle)*radius;
			shape[i+1] = MathUtils.sin(angle)*radius;
			angle += angleStep;
		}

		return shape;
	}
	
	public static float[] astroid(float radius, int sections){
		float angleStep = (MathUtils.PI*2)/sections, angle = 0;
		float[] shape = new float[sections*2];
		
		for(int i = 0; i < sections*2; i += 2){
			float ran =  MathUtils.random(-1,1);
			shape[i] = MathUtils.cos(angle)*(radius+ran);
			shape[i+1] = MathUtils.sin(angle)*(radius+ran);
			angle += angleStep;
		}

		return shape;
	}
	
	public static float[] square(float width, float height){
		float[] shape = {0,0, width,0, height,width, 0,height};
		return  shape;
	}
}
