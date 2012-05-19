package com.oddfry.physics;

public abstract class MoveUpdater {
	/* PUBLIC */
	/**
	 * Constructor
	 */
	public MoveUpdater() {
		
	}
	
	
	/**
	 * Move
	 * @param movable
	 */
	public abstract void move(Movable movable);
}
