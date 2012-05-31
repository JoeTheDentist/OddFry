package com.oddfry.physics;

public class MoveUpdaterHorizontal extends MoveUpdater {

	@Override
	protected int fx(Movable m) {
		if (getDir() == Direction.LEFT || getDir() == Direction.UP) {
			return -1;
		} else {
			return 1;
		}
	}

	@Override
	protected int fy(Movable m) {
		return 0;
	}

	@Override
	protected float getOffsetRate() {
		return 0.25f;
	}
}
