package com.gdxjam.orion.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;

public class RevoluteJoint {
	RevoluteJointDef revoluteJointDef;

	public RevoluteJoint(Body bodyA, Body bodyB, boolean collideConnected) {
		revoluteJointDef = new RevoluteJointDef();
		CreateRevoluteJoint(bodyA, bodyB, collideConnected);
	}

	void CreateRevoluteJoint(Body bodyA, Body bodyB, boolean collideConnected) {
		revoluteJointDef.bodyA = bodyA;
		revoluteJointDef.bodyB = bodyB;
		revoluteJointDef.collideConnected = collideConnected;

	}

	public void setAnchorA(float x, float y) {
		revoluteJointDef.localAnchorA.set(x, y);
	}

	public void setAnchorB(float x, float y) {
		revoluteJointDef.localAnchorB.set(x, y);
	}

	public void setAngleLimit(float min, float max) {
		revoluteJointDef.enableLimit = true;
		revoluteJointDef.lowerAngle = min * MathUtils.degreesToRadians;
		revoluteJointDef.upperAngle = max * MathUtils.degreesToRadians;
	}

	public void setMotor(float torque, float speed) {
		revoluteJointDef.enableMotor = true;
		revoluteJointDef.maxMotorTorque = torque;
		revoluteJointDef.motorSpeed = speed * MathUtils.degreesToRadians;
	}

	public Joint createJoint(World world) {
		return world.createJoint(revoluteJointDef);
	}
}
