package com.oddfry.update;

import com.oddfry.actors.FriesCrowd;
import com.oddfry.graphics.Background;

/**
 * Loop which refreshes the menu
 * 
 * @author Guillaume Berard
 *
 */
public class MenuLoop extends UpdateLoop {

	//TEMP
	private FriesCrowd fries_;
	private Background back_;
	
	
	/* PUBLIC */
	/**
	 * Constructor
	 */
	public MenuLoop() {
		back_ = new Background();
		fries_ = new FriesCrowd();
	}
	
	
	/* PROTECTED */
	@Override
	final protected void update() {
		getScreen().lock();
		back_.draw();
		fries_.draw();
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
