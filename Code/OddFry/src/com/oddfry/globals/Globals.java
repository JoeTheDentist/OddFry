package com.oddfry.globals;

import com.oddfry.update.*;

/**
 * Singleton class controlling the full game
 * 
 * @author Guillaume Berard
 *
 */
public class Globals {
	
	/* PUBLIC */
	/*		CLASS */
	/**
	 * Display and update menus
	 */
	public void setMenu() {
		if ( loop_ != null ) {
			loop_.setRunning(false);
			try {
				loop_.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		loop_ = new MenuLoop();
		loop_.start();
	}
	
	
	/**
	 * Display and update game
	 */
	public void setGame() {
		if ( loop_ != null ) {
			loop_.setRunning(false);
			try {
				loop_.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		loop_ = new GameLoop();
		loop_.start();
	}
	
	
	/**
	 * Stop the app
	 */
	public void stopApp() {
		//Oh yeah! 
		android.os.Process.killProcess(android.os.Process.myPid());
	}
	
	
	/**
	 * Win
	 */
	public void win() {
		((GameLoop)loop_).win();
	}
	
	
	/**
	 * Loose
	 */
	public void loose() {
		((GameLoop)loop_).loose();
	}
	
	
	/**
	 * Get current game time
	 * @return current time in milliseconds
	 */
	public int getTime() {
		//TODO game can slow down or speed up
		return (int) System.currentTimeMillis();
	}
	
	
	/*		STATIC */
	synchronized public static Globals GetInstance() {
		if ( INSTANCE_ == null) {
			INSTANCE_ = new Globals();
		}
		return INSTANCE_;
	}
	
	
	/* PRIVATE */
	/* 		CLASS */
	private UpdateLoop loop_;
	
	
	/**
	 * Constructor
	 */
	private Globals() {
		
	}
	
	
	/* 		STATIC */
	private static Globals INSTANCE_;
}
