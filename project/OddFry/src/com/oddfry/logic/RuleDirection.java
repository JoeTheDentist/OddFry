package com.oddfry.logic;

import com.oddfry.physics.MoveUpdater;
import com.oddfry.physics.MoveUpdaterHorizontal;
import com.oddfry.physics.MoveUpdaterVertical;

public class RuleDirection extends Rule {

	@Override
	public MoveUpdater getNormalUpdater() {
		return new MoveUpdaterVertical();
	}

	@Override
	public MoveUpdater getOddUpdater() {
		return new MoveUpdaterHorizontal();
	}

	@Override
	public int getTimeToSolve() {
		return 15000;
	}

}
