package com.oddfry.actors;

import com.oddfry.R;
import com.oddfry.graphics.Animation;

public class NormalFry extends Actor {
	public NormalFry() {
		super();
		anim_ = new Animation(R.drawable.fry_states);
		//TODO, set good img and period
		int tab[] = {0,1,2,3};
		anim_.setAnimation(tab, 100);
		x_ = 100;
		y_ = 100;
	}
}
