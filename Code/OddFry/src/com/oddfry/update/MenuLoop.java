package com.oddfry.update;

import com.oddfry.actors.NormalFry;
import com.oddfry.graphics.Background;

/**
 * Loop which refreshes the menu
 * 
 * @author Guillaume Berard
 *
 */
public class MenuLoop extends UpdateLoop {

	//TEMP
	private NormalFry fry_;
	private Background back_;
	
	
	/* PUBLIC */
	/**
	 * Constructor
	 */
	public MenuLoop() {
		fry_ = new NormalFry();
		back_ = new Background();
	}
	
	
	/* PROTECTED */
	@Override
	final protected void update() {
		getScreen().lock();
		back_.draw();
		fry_.draw();
		getScreen().unlock();
	}

	
	@Override
	protected void postUpdate() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
