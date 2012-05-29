package com.oddfry.physics;

import com.oddfry.graphics.Screen;

public class MoveUpdaterStayInQuarter extends MoveUpdater {

	/* PUBLIC */
	/**
	 * Constructor
	 */
	public MoveUpdaterStayInQuarter() {
		super();
	}


	/* PROTECTED */
	@Override
	protected int fx(Movable m) {
		if (m.getX() < Screen.GetInstance().getW()/20) {
			return 1;
		} else if ( m.getX() > 9*Screen.GetInstance().getW()/20 &&
				m.getX() < 10*Screen.GetInstance().getW()/20) {
			return -1;
		} else if ( m.getX() > 10*Screen.GetInstance().getW()/20 &&
				m.getX() < 11*Screen.GetInstance().getW()/20) {
			return 1;
		} else if ( m.getX() > 19*Screen.GetInstance().getW()/20 ) {
			return -1;
		} else {
			return 0;
		}
	}

	
	@Override
	protected int fy(Movable m) {
		if (m.getY() < Screen.GetInstance().getH()/20) {
			return 1;
		} else if ( m.getY() > 9*Screen.GetInstance().getH()/20 &&
				m.getY() < 10*Screen.GetInstance().getH()/20) {
			return -1;
		} else if ( m.getY() > 10*Screen.GetInstance().getH()/20 &&
				m.getY() < 11*Screen.GetInstance().getH()/20) {
			return 1;
		} else if ( m.getY() > 19*Screen.GetInstance().getH()/20 ) {
			return -1;
		} else {
			return 0;
		}
	}
	
	
	@Override
	protected float getSpeed() {
		return SPEED_*2;
	}
}
