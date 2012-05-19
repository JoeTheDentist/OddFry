package com.oddfry.graphics;

import com.oddfry.R;
import com.oddfry.globals.ResourcesUtil;

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
		for (int i=0; i*tile_.h()<ResourcesUtil.GetScreen().getHeight(); i++) {
			for (int j=0; j*tile_.w()<ResourcesUtil.GetScreen().getWidth(); j++) {
				ResourcesUtil.GetScreen().drawImage(tile_, j*tile_.w(), i*tile_.h());
			}
		}
	}
	
	/* PRIVATE */
	private Image tile_;
}
