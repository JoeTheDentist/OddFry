package com.oddfry.physics;

import java.util.Random;

import com.oddfry.globals.Globals;
import com.oddfry.globals.ResourcesUtil;

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
		lastTime_ = Globals.GetInstance().getTime();
	}
	
	
	@Override
	public void move(Movable movable) {
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
		
		float deltaTime = Globals.GetInstance().getTime() - lastTime_;
		lastTime_ = Globals.GetInstance().getTime();
		
		float move = SPEED_*deltaTime / 1000;
		
		switch (lastDirection_) {
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
	private int lastTime_;
	private Direction lastDirection_ = Direction.LEFT;
	private int timeLastMove_;
	private int lastDuration_ = 0;
	
	
	
	private void setInScreen(Movable movable) {
		if ( movable.getX() < 0 ) {
			movable.setX(0);
			lastDirection_ = Direction.DOWN;
		} else if ( movable.getX() + movable.getW() > ResourcesUtil.GetScreen().getW() ) {
			movable.setX(ResourcesUtil.GetScreen().getW()-movable.getW());
			lastDirection_ = Direction.UP;
		}
		if ( movable.getY() < 0 ) {
			movable.setY(0);
			lastDirection_ = Direction.RIGHT;
		} else if ( movable.getY() + movable.getH() > ResourcesUtil.GetScreen().getH() ) {
			movable.setY(ResourcesUtil.GetScreen().getH()-movable.getH());
			lastDirection_ = Direction.LEFT;
		}
	}
	
	
	/*		STATIC */
	private float SPEED_ = 25;	//pixels per second
}
