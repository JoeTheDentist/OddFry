package com.oddfry.physics;

/**
 * 
 * 
 * @author Guillaume Berard
 *
 */
public class Mover {
	
	/* PUBLIC */
	/**
	 * COnstructor
	 * @param movable
	 */
	public Mover(Movable movable) {
		movable_ = movable;
		moveUpdater_ = new MoveUpdaterNull();
	}
	
	
	/**
	 * COnstructor
	 * @param movable
	 * @param moveUpdater
	 */
	public Mover(Movable movable, MoveUpdater moveUpdater) {
		movable_ = movable;
		moveUpdater_ = moveUpdater;
	}
	
	
	/**
	 * Update
	 */
	public void move() {
		moveUpdater_.move(movable_);
	}
	
	
	/* PRIVATE */
	private Movable movable_;
	private MoveUpdater moveUpdater_;
}
