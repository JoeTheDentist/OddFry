package com.oddfry.physics;

import java.util.Random;

import com.oddfry.globals.Globals;
import com.oddfry.graphics.Screen;

public abstract class MoveUpdater {
	/* PUBLIC */
	/**
	 * Constructor
	 */
	public MoveUpdater() {
		timeLastMove_ = Globals.GetInstance().getTime();
	}
	
	
	/**
	 * Move
	 * @param movable
	 */
	public void move(Movable movable) {
		float move = getSpeed()*Globals.GetInstance().getDt() / 1000;
		
		movable.moveX(fx(movable)*move+getOffsetX()*getOffsetRate()*move);
		movable.moveY(fy(movable)*move+getOffsetY()*getOffsetRate()*move);
		
		setInScreen(movable);
	}
	
	
	/* PROTECTED */
	protected static final float SPEED_ = 35;	//pixels per second
	
	
	/**
	 * 
	 * @param m
	 * @return
	 */
	protected abstract int fx(Movable m);
	
	
	/**
	 * 
	 * @param m
	 * @return
	 */
	protected abstract int fy(Movable m);
	
	
	/**
	 * Getter
	 * @return direction
	 */
	protected Direction getDir() {
		if (Globals.GetInstance().getTime() - timeLastMove_ > lastDuration_) {
			Random rand = new Random();
			timeLastMove_ = Globals.GetInstance().getTime();
			lastDuration_ = 1000+rand.nextInt(2000);
			switch (rand.nextInt(4)) {
			case 0:
				lastDirection_ = Direction.LEFT;
				break;
			case 1:
				lastDirection_ = Direction.RIGHT;
				break;
			case 2:
				lastDirection_ = Direction.UP;
				break;
			case 3:
				lastDirection_ = Direction.DOWN;
				break;
			default:
				break;
			}
		}
		return lastDirection_;
	}
	
	
	/**
	 * Get random offset x
	 * @return
	 */
	protected float getOffsetX() {
		if (getDir() == Direction.LEFT) {
			return -1;
		} else if (getDir() == Direction.RIGHT) {
			return 1;
		} else {
			return 0;
		}
	}
	
	
	/**
	 * Get random offset y
	 * @return
	 */
	protected float getOffsetY() {
		if (getDir() == Direction.UP) {
			return -1;
		} else if (getDir() == Direction.DOWN) {
			return 1;
		} else {
			return 0;
		}
	}
	
	
	/**
	 * Set in screen
	 * @param movable
	 */
	protected void setInScreen(Movable movable) {
		if ( movable.getX() < 0 ) {
			movable.setX(0);
			lastDirection_ = Direction.DOWN;
		} else if ( movable.getX() + movable.getW() > Screen.GetInstance().getW() ) {
			movable.setX(Screen.GetInstance().getW()-movable.getW());
			lastDirection_ = Direction.UP;
		}
		if ( movable.getY() < 0 ) {
			movable.setY(0);
			lastDirection_ = Direction.RIGHT;
		} else if ( movable.getY() + movable.getH() > Screen.GetInstance().getH() ) {
			movable.setY(Screen.GetInstance().getH()-movable.getH());
			lastDirection_ = Direction.LEFT;
		}
	}
	
	
	/**
	 * Get speed
	 * @return speed
	 */
	protected float getSpeed() {
		return SPEED_;
	}
	
	
	/**
	 * Rate of the speed for the offset movement
	 * @return rate
	 */
	protected float getOffsetRate() {
		return 0.5f;
	}
	
	
	/* PRIVATE */
	private Direction lastDirection_ = Direction.LEFT;
	private int timeLastMove_;
	private int lastDuration_ = 0;
}
