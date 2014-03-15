package com.oddfry.logic;

import com.oddfry.globals.Globals;

/**
 * Time counter.</br>
 * Time left.
 * 
 * @author Guillaume Berard
 *
 */
public class Time {
	
	/* PUBLIC */
	/*		CLASS */
	/**
	 * Setter
	 * @param ms : time left, in milliseconds
	 */
	public void setTime(int ms) {
		timeLeft_ = ms;
		lastUpdate_ = Globals.GetInstance().getTime();
	}
	
	
	/**
	 * Getter
	 * @return time left in milliseconds
	 */
	public int getTimeLeft() {
		return timeLeft_;
	}
	
	
	/**
	 * Update
	 */
	public void update() {
		timeLeft_ -= (Globals.GetInstance().getTime() - lastUpdate_);
		lastUpdate_ = Globals.GetInstance().getTime();
	}
	
	
	/*		STATIC */
	synchronized public static Time GetInstance() {
		if (INSTANCE_ == null) {
			INSTANCE_ = new Time();
		}
		return INSTANCE_;
	}
	
	
	/* PRIVATE */
	/*		CLASS */
	private int timeLeft_;
	private int lastUpdate_;
	
	
	/**
	 * Constructor
	 */
	private Time() {
		
	}
	
	
	/*		STATIC */
	private static Time INSTANCE_;
}
