package com.oddfry.physics;

import com.oddfry.globals.Globals;


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
	
	
	@Override
	public void move(Movable movable) {
		float move = SPEED_*Globals.GetInstance().getDt() / 1000;
		
		movable.moveX(getOffsetX()*move);
		movable.moveY(getOffsetY()*move);
		
		setInScreen(movable);
	}
	

	/* PRIVATE */
	/*		CLASS */
	
	
	/*		STATIC */
	private static final float SPEED_ = 25;	//pixels per second
}
