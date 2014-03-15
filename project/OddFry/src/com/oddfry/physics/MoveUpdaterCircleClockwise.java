package com.oddfry.physics;

import com.oddfry.graphics.Screen;

public class MoveUpdaterCircleClockwise extends MoveUpdater {

	/* PUBLIC */
	/**
	 * Constructor
	 */
	public MoveUpdaterCircleClockwise() {
		super();
	}

	
	/* PROTECTED */
	@Override
	protected int fx(Movable m) {
		float line1 = Screen.GetInstance().getH()/Screen.GetInstance().getW()*m.getX();
		float line2 = -Screen.GetInstance().getH()/Screen.GetInstance().getW()*m.getX()+
				Screen.GetInstance().getH();
		
		if ( m.getY()+m.getH() > line1 && m.getY() > line2 ) {
			return -1;
		} else if ( m.getY() < line1 && m.getY() < line2 ) {
			return 1;
		} else {
			return 0;
		}
	}
	
	
	@Override
	protected int fy(Movable m) {
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
}
