package com.oddfry.physics;


/**
 * Behavior of all fries for the menu
 * 
 * @author Guillaume Berard
 *
 */
public class MoveUpdaterMenu extends MoveUpdater {
	
	/* PUBLIC */
	/**
	 * Constructor
	 */
	public MoveUpdaterMenu() {
		super();
	}
	
	
	/* PROTECTED */
	@Override
	protected int fx(Movable m) {
		return 0;
	}
	
	
	@Override
	protected int fy(Movable m) {
		return 0;
	}
	

	@Override
	protected float getSpeed() {
		return SPEED_*2;
	}
}
