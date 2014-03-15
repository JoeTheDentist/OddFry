package com.oddfry.logic;

import com.oddfry.physics.MoveUpdater;
import com.oddfry.physics.MoveUpdaterMenu;
import com.oddfry.physics.MoveUpdaterTimeBehavior;

public class RuleTimeBehavior extends Rule {

	@Override
	public MoveUpdater getNormalUpdater() {
		return new MoveUpdaterTimeBehavior();
	}

	@Override
	public MoveUpdater getOddUpdater() {
		return new MoveUpdaterMenu();
	}

	@Override
	public int getTimeToSolve() {
		return 10000;
	}

}
