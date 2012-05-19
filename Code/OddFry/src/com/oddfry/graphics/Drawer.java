package com.oddfry.graphics;

import com.oddfry.globals.ResourcesUtil;

public class Drawer {
	
	/* PUBLIC */
	/**
	 * Constructor
	 * @param drawable
	 */
	public Drawer(Drawable drawable) {
		drawable_ = drawable;
	}
	
	
	/**
	 * Draw the drawable now !
	 */
	public void draw() {
		ResourcesUtil.GetScreen().drawImage(drawable_.getImage(), drawable_.getX(), drawable_.getY());
	}
	
	
	/* PRIVATE */
	private Drawable drawable_;
}
