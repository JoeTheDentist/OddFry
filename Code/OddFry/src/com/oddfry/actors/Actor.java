package com.oddfry.actors;

import com.oddfry.graphics.Animation;
import com.oddfry.graphics.Drawable;
import com.oddfry.graphics.Drawer;
import com.oddfry.graphics.Image;
import com.oddfry.physics.Movable;
import com.oddfry.physics.Mover;

public abstract class Actor implements Drawable, Movable, Comparable<Actor> {	
	
	/* PUBLIC */
	/**
	 * Constructor
	 */
	public Actor() {
		drawer_ = new Drawer(this);
	}
	
	
	/**
	 * Getter
	 * @return x
	 */
	public float getX() {
		return x_;
	}

	
	/**
	 * Getter
	 * @return y
	 */
	public float getY() {
		return y_;
	}
	
	
	/**
	 * Setter
	 * @param x
	 */
	public void setX(float x) {
		x_ = x;
	}

	
	/**
	 * Setter
	 * @param y
	 */
	public void setY(float y) {
		y_ = y;
	}
	
	
	/**
	 * Setter
	 * @param x
	 */
	public void moveX(float x) {
		x_ += x;
		if ( x>0 ) {
			lookRight();
		} else {
			lookLeft();
		}
	}
	
	
	/**
	 * Setter
	 * @param y
	 */
	public void moveY(float y) {
		y_ += y;
		if ( y>0 ) {
			lookDown();
		} else {
			lookUp();
		}
	}
	
	
	/**
	 * Getter
	 * @return height
	 */
	public float getH() {
		return anim_.getH();
	}
	
	
	/**
	 * Getter
	 * @return width
	 */
	public float getW() {
		return anim_.getW();
	}
	
	
	/**
	 * Getter
	 * @return current image
	 */
	public Image getImage() {
		return anim_.getCurrentImage();
	}
	
	
	/**
	 * Draw now !
	 */
	public void draw() {
		getDrawer().draw();
	}
	
	
	/**
	 * Move the actor according to the MoveUpdater
	 */
	public void move() {
		getMover().move();
	}
	
	
	/**
	 * Order, for sorting
	 * @param a
	 * @return
	 */
	public int compareTo(Actor a) {
		return (int) (getY()-a.getY());
	}
	
	
	/* PROTECTED */
	protected Animation anim_;
	protected Mover mover_;
	protected float x_;
	protected float y_;
	
	
	/**
	 * Look left
	 */
	protected abstract void lookLeft();
	
	
	/**
	 * Look right
	 */
	protected abstract void lookRight();
	
	
	/**
	 * Look up
	 */
	protected abstract void lookUp();
	
	
	/**
	 * Look down
	 */
	protected abstract void lookDown();
	
	
	/**
	 * Getter
	 * @return drawer
	 */
	protected Drawer getDrawer() {
		return drawer_;
	}
	
	
	/* PRIVATE */
	private Drawer drawer_;
	
	
	/**
	 * Getter
	 * @return mover
	 */
	private Mover getMover() {
		return mover_;
	}
}
