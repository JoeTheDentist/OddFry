package com.oddfry.physics;

import java.util.Random;

import com.oddfry.globals.Globals;
import com.oddfry.graphics.Screen;

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
		
		switch (getDir()) {
		case LEFT:
			movable.moveX(-move);
			break;
		case RIGHT:
			movable.moveX(move);
			break;
		case UP:
			movable.moveY(-move);
			break;
		case DOWN:
			movable.moveY(move);
			break;
		default:
			break;
		}
		
		setInScreen(movable);
	}
	

	/* PRIVATE */
	/*		CLASS */
	
	
	/*		STATIC */
	private static final float SPEED_ = 25;	//pixels per second
}
