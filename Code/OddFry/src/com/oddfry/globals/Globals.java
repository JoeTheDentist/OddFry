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
	 * Starts looping
	 */
	public void run() {
		loop_.start();
	}
	
	
	/**
	 * Display and update menus
	 */
	public void setMenu() {
		loop_ = new MenuLoop();
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
