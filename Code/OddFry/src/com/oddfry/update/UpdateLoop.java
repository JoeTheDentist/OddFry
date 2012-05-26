package com.oddfry.update;

import com.oddfry.globals.Globals;
import com.oddfry.graphics.Screen;

/**
 * Logic which updates logic and graphic
 * 
 * @author Guillaume Berard
 *
 */
public abstract class UpdateLoop extends Thread {
	
	/* PUBLIC */
	/**
	 * Update
	 */
	public UpdateLoop() {
		screen_ = Screen.GetInstance();
		lastUpdate_ = Globals.GetInstance().getTime();
		lastlastUpdate_ = lastUpdate_;
	}
	
	
	/**
	 * Getter
	 * @return true if running
	 */
	synchronized public boolean isRunning() {
		return running_;
	}
	
	
	/**
	 * Setter
	 * @param running
	 */
	synchronized public void setRunning(boolean running) {
		running_ = running;
	}
	
	
	/**
	 * Run the thread
	 */
	public void run() {
		setRunning(true);
		while (isRunning()) {
			lastlastUpdate_ = lastUpdate_;
			lastUpdate_ = Globals.GetInstance().getTime();
			update();
			postUpdate();
		}
	}
	
	
	/**
	 * Get delta time
	 * @return delta time
	 */
	public float getDt() {
		return lastUpdate_ - lastlastUpdate_;
	}
	
	
	/* PROTECTED */
	/**
	 * Update
	 */
	protected abstract void update();
	
	
	/**
	 * Post Update
	 */
	protected abstract void  postUpdate();
	
	
	/**
	 * Getter
	 * @return screen
	 */
	protected Screen getScreen() {
		return screen_;
	}
	
	
	/* PRIVATE */
	private Screen screen_;
	private boolean running_;
	private int lastUpdate_;
	private int lastlastUpdate_;
}
