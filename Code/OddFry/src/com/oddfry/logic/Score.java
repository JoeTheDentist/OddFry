package com.oddfry.logic;


/**
 * Score of the player</br>
 * Singleton
 * 
 * @author Guillaume Berard
 *
 */
public class Score {
	/* PUBLIC */
	/* 		CLASS */
	/**
	 * Update the score
	 */
	public void update() {
		//TODO
	}
	
	
	/**
	 * Getter
	 * @return score
	 */
	public int getScore() {
		return score_;
	}
	
	
	/*		STATIC */
	synchronized public static Score GetInstance() {
		if (INSTANCE_ == null) {
			INSTANCE_ = new Score();
		}
		return INSTANCE_;
	}
	
	
	/* PRIVATE */
	/*		CLASS */
	private int score_;
	
	
	/**
	 * Constructor
	 */
	private Score() {
		
	}
	
	
	/*		STATIC */
	private static Score INSTANCE_;
}
