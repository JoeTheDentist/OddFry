package com.oddfry.physics;

import com.oddfry.globals.Globals;

public class MoveUpdaterTimeBehavior extends MoveUpdater {

	@Override
	protected int fx(Movable m) {
		return 0;
	}

	@Override
	protected int fy(Movable m) {
		return 0;
	}

	@Override
	protected float getOffsetRate() {
		if (Globals.GetInstance().getTime()/1000 % 2 == 0) {
			return 1;
		} else {
			return 0;
		}
	}
}
