package com.oddfry.update;

import com.oddfry.globals.ResourcesUtil;
import com.oddfry.graphics.Screen;

/**
 * Logic which updates logic and graphic
 * 
 * @author Guillaume Berard
 *
 */
public abstract class UpdateLoop extends Thread {
	
	/* PUBLIC */
	public UpdateLoop() {
		screen_ = new Screen(ResourcesUtil.GetActivity());
	}
	
	
	/**
	 * Run the thread
	 */
	public void run() {
		setRunning(true);
		while (isRunning()) {
			update();
			postUpdate();
		}
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
	
	
	/**
	 * Getter
	 * @return true if running
	 */
	synchronized private boolean isRunning() {
		return running_;
	}
	
	
	/**
	 * Setter
	 * @param running
	 */
	synchronized private void setRunning(boolean running) {
		running_ = running;
	}
}
