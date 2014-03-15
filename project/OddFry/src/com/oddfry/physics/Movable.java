package com.oddfry.physics;

/**
 * Which can be moved
 * 
 * @author Guillaume Berard
 *
 */
public interface Movable {
	public float getX();
	public float getY();
	public void setX(float x);
	public void setY(float y);
	public void moveX(float x);
	public void moveY(float y);
	public float getH();
	public float getW();
}
