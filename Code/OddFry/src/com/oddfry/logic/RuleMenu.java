package com.oddfry.logic;

import com.oddfry.globals.Globals;
import com.oddfry.graphics.Screen;
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
