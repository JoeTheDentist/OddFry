package com.oddfry.update;

import com.oddfry.actors.NormalFry;

/**
 * Loop which refreshes the menu
 * 
 * @author Guillaume Berard
 *
 */
public class MenuLoop extends UpdateLoop {

	//TEMP
	private NormalFry fry_;
	
	
	/* PUBLIC */
	/**
	 * Constructor
	 */
	public MenuLoop() {
		fry_ = new NormalFry();
	}
	
	
	/* PROTECTED */
	@Override
	final protected void update() {
		getScreen().lock();
		fry_.draw();
		fry_.move();
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
