package com.oddfry.logic;

import com.oddfry.physics.MoveUpdater;
import com.oddfry.physics.MoveUpdaterCircleAnticlockwise;
import com.oddfry.physics.MoveUpdaterStayInQuarter;

public class RuleCorners extends Rule {

	@Override
	public MoveUpdater getNormalUpdater() {
		return new MoveUpdaterStayInQuarter();
	}

	@Override
	public MoveUpdater getOddUpdater() {
		return new MoveUpdaterCircleAnticlockwise();
	}

	@Override
	public int getTimeToSolve() {
		return 30000;
	}

}
