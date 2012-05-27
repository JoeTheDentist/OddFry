package com.oddfry.physics;

import com.oddfry.globals.Globals;
import com.oddfry.graphics.Screen;

public class MoveUpdaterCircleAnticlockwise extends MoveUpdater {

	/* PUBLIC */
	/**
	 * Constructor
	 */
	public MoveUpdaterCircleAnticlockwise() {
		super();
	}
	
	
	@Override
	public void move(Movable movable) {
		float move = SPEED_*Globals.GetInstance().getDt() / 1000;
		
		movable.moveX(-fx(movable)*move+getOffsetX()*move/2);
		movable.moveY(-fy(movable)*move+getOffsetY()*move/2);
		
		setInScreen(movable);
	}

	
	/* PRIVATE */
	/*		CLASS */
	private float fx(Movable m) {
		float line1 = Screen.GetInstance().getH()/Screen.GetInstance().getW()*m.getX();
		float line2 = -Screen.GetInstance().getH()/Screen.GetInstance().getW()*m.getX()+
				Screen.GetInstance().getH();
		
		if ( m.getY() > line1 && m.getY()+m.getH() > line2 ) {
			return -1;
		} else if ( m.getY() < line1 && m.getY() < line2 ) {
			return 1;
		} else {
			return 0;
		}
	}
	
	
	private float fy(Movable m) {
		float line1 = Screen.GetInstance().getH()/Screen.GetInstance().getW()*m.getX();
		float line2 = -Screen.GetInstance().getH()/Screen.GetInstance().getW()*m.getX()+
				Screen.GetInstance().getH();
		
		if ( m.getY() < line1 && m.getY()+m.getH() > line2 ) {
			return 1;
		} else if ( m.getY() > line1 && m.getY() < line2 ) {
			return -1;
		} else {
			return 0;
		}
	}
	
	
	/*		STATIC */
	private static final float SPEED_ = 25;	//pixels per second
}
