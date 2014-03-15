package com.oddfry.graphics;

import com.oddfry.R;

/**
 * Class aimed to fill the background
 * 
 * @author Guillaume Berard
 *
 */
public class Background {
	
	/* PUBLIC */
	/**
	 * Constructor
	 */
	public Background() {
		tile_ = new Image(R.drawable.tile);
	}
	
	
	/**
	 * Fill the screen with tiles
	 */
	public void draw() {
		for (int i=0; i*tile_.h()<Screen.GetInstance().getH(); i++) {
			for (int j=0; j*tile_.w()<Screen.GetInstance().getW(); j++) {
				Screen.GetInstance().drawImage(tile_, j*tile_.w(), i*tile_.h());
			}
		}
	}
	
	
	/* PRIVATE */
	private Image tile_;
}
