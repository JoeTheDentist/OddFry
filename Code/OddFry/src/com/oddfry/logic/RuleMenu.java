package com.oddfry.logic;

import com.oddfry.physics.MoveUpdater;
import com.oddfry.physics.MoveUpdaterMenu;

/**
 * Special rule, only for menu
 * 
 * @author Guillaume Berard
 *
 */
public class RuleMenu extends Rule {

	@Override
	public MoveUpdater getNormalUpdater() {
		return new MoveUpdaterMenu();
	}

	@Override
	public MoveUpdater getOddUpdater() {
		return new MoveUpdaterMenu();
	}

	@Override
	public int getTimeToSolve() {
		return 0;
	}
}
