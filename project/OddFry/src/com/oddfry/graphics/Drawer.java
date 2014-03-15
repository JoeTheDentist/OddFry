package com.oddfry.graphics;

public class Drawer {
	
	/* PUBLIC */
	/**
	 * Constructor
	 * @param drawable
	 */
	public Drawer(Drawable drawable) {
		drawable_ = drawable;
		circle_ = false;
	}
	
	
	/**
	 * Draw the drawable now !
	 */
	public void draw() {
		Screen.GetInstance().drawImage(drawable_.getImage(), drawable_.getX(), drawable_.getY());
		if (circle_) {
			Screen.GetInstance().drawCircle(drawable_.getX()+drawable_.getW()/2,
					drawable_.getY()+drawable_.getH()/2,
					drawable_.getH()/2);
		}
	}
	
	
	/**
	 * Setter
	 * @param circle
	 */
	public void setCircle(boolean circle) {
		circle_ = circle;
	}
	
	
	/* PRIVATE */
	private Drawable drawable_;
	private boolean circle_;
}
