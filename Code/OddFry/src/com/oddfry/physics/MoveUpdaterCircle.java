package com.oddfry.physics;

import java.util.Random;

import com.oddfry.globals.Globals;

public class MoveUpdaterCircle extends MoveUpdater {

	/* PUBLIC */
	/**
	 * Constructor
	 */
	public MoveUpdaterCircle() {
		super();
		lastTimeMove_ = Globals.GetInstance().getTime();
		Random rand = new Random();
		hor_ = (rand.nextInt(1) == 0);
	}
	
	
	@Override
	public void move(Movable movable) {
		if (hor_) {
			movable.moveX(0);
		} else {
			movable.moveY(0);
		}
	}

	
	/* PRIVATE */
	/*		CLASS */
	private boolean hor_ = false;
	private float lastTimeMove_;
	
	
	/*		STATIC */
	private static final float SPEED_ = 25;	//pixels per second
}
