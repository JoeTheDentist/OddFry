package com.oddfry.controls;

import com.oddfry.graphics.Menu;

import android.view.MotionEvent;

/**
 * Controller for menu
 * 
 * @author Guillaume Berard
 *
 */
public class MenuController extends Controller {
	
	/* PUBLIC */
	/**
	 * Constructor
	 */
	public MenuController() {
		ControlsManager.GetInstance().setController(this);
	}
	

	/* PACKAGE */
	@Override
	void touch(MotionEvent event) {
		if ( event.getActionMasked() == MotionEvent.ACTION_UP || 
				event.getActionMasked() == MotionEvent.ACTION_POINTER_UP ) {
			((Menu)target_).point(event.getX(), event.getY());
		}
	}

}
