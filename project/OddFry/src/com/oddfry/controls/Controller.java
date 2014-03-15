package com.oddfry.controls;

import android.view.MotionEvent;

/**
 * Receives and uses the touch inputs
 * 
 * @author Guillaume Berard
 *
 */
public abstract class Controller {
	
	/* PUBLIC */
	public void setTarget(Controlled target) {
		target_ = target;
	}
	
	/* PACKAGE */
	/**
	 * On touch
	 * @param event
	 */
	abstract void touch(MotionEvent event);
	
	/* PROTECTED */
	protected Controlled target_;
}
