package com.oddfry.physics;

public class MoveUpdaterVertical extends MoveUpdater {

	@Override
	protected int fx(Movable m) {
		return 0;
	}

	@Override
	protected int fy(Movable m) {
		if (getDir() == Direction.LEFT || getDir() == Direction.UP) {
			return -1;
		} else {
			return 1;
		}
	}

	@Override
	protected float getOffsetRate() {
		return 0.25f;
	}
}
