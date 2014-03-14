package com.oddfry.logic;

import com.oddfry.physics.MoveUpdater;
import com.oddfry.physics.MoveUpdaterHorizontal;
import com.oddfry.physics.MoveUpdaterStayInQuarter;

public class RuleCorners extends Rule {

	@Override
	public MoveUpdater getNormalUpdater() {
		return new MoveUpdaterStayInQuarter();
	}

	@Override
	public MoveUpdater getOddUpdater() {
		return new MoveUpdaterHorizontal();
	}

	@Override
	public int getTimeToSolve() {
		return 25000;
	}

}
