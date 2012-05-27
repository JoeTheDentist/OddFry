package com.oddfry.logic;

import com.oddfry.globals.Globals;
import com.oddfry.graphics.Screen;
import com.oddfry.physics.MoveUpdater;
import com.oddfry.physics.MoveUpdaterCircleAnticlockwise;
import com.oddfry.physics.MoveUpdaterCircleClockwise;

public class RuleCircle extends Rule {

	@Override
	public MoveUpdater getNormalUpdater() {
		return new MoveUpdaterCircleAnticlockwise();
	}

	@Override
	public MoveUpdater getOddUpdater() {
		return new MoveUpdaterCircleClockwise();
	}

	@Override
	public float getX() {
		return Globals.GetInstance().
				getRand().nextFloat()*Screen.GetInstance().getW();
	}

	@Override
	public float getY() {
		return Globals.GetInstance().
				getRand().nextFloat()*Screen.GetInstance().getH();
	}

}
