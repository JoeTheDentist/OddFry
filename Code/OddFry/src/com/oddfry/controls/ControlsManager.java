package com.oddfry.controls;

import android.view.MotionEvent;

/**
 * Manages the inputs.</br>
 * Singleton
 * 
 * @author Guillaume Berard
 *
 */
public class ControlsManager {
	
	/* PUBLIC */
	/*		CLASS */
	/**
	 * On touch
	 * @param event
	 */
	public void touch(MotionEvent event) {
		if (controller_ != null) {
			controller_.touch(event);
		}
	}
	
	
	/*		STATIC */
	/**
	 * Getter
	 * @return instance
	 */
	synchronized public static ControlsManager GetInstance() {
		if (INSTANCE_ == null) {
			INSTANCE_ = new ControlsManager();
		}
		return INSTANCE_;
	}
	
	
	/* PACKAGE */
	/**
	 * Setter
	 * @param controller
	 */
	void setController(Controller controller) {
		controller_ = controller;
	}
	
	
	/* PRIVATE */
	/*		CLASS */
	private Controller controller_;
	
	
	/**
	 * Constructor
	 */
	private ControlsManager() {
		
	}
	
	
	/*		STATIC */
	private static ControlsManager INSTANCE_;
}
