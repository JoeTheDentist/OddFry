package com.oddfry.logic;

import com.oddfry.physics.MoveUpdater;
import com.oddfry.physics.MoveUpdaterMenu;

public class RuleMenu extends Rule {

	@Override
	public MoveUpdater getNormalUpdater() {
		return new MoveUpdaterMenu();
	}

	@Override
	public MoveUpdater getOddUpdater() {
		return new MoveUpdaterMenu();
	}
}
