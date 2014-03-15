package com.oddfry.physics;

public class MoveUpdaterNull extends MoveUpdater{

	@Override
	public void move(Movable movable) {}
	
	
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
		return 0;
	}
}
