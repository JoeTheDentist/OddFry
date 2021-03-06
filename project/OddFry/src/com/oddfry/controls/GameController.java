package com.oddfry.controls;

import com.oddfry.update.GameLoop;

import android.view.MotionEvent;

/**
 * Controller for the game
 * 
 * @author Guillaume Berard
 *
 */
public class GameController extends Controller {

	/* PUBLIC */
	/**
	 * Constructor
	 */
	public GameController() {
		ControlsManager.GetInstance().setController(this);
	}
	
	
	/* PACKAGE */
	@Override
	void touch(MotionEvent event) {
		if ( event.getActionMasked() == MotionEvent.ACTION_UP || 
				event.getActionMasked() == MotionEvent.ACTION_POINTER_UP ) {
			((GameLoop)target_).point(event.getX(), event.getY());
		}
	}

}
