package com.oddfry.logic;

import com.oddfry.globals.Globals;

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
		if (Time.GetInstance().getTimeLeft()<0) {
			score_ -= Globals.GetInstance().getDt()*MULT_;
		}
		if ( score_ < 0) {
			Globals.GetInstance().lose();
		}
	}
	
	
	/**
	 * Getter
	 * @return score
	 */
	public int getScore() {
		return score_;
	}
	
	
	/**
	 * Add time to score, at the end of the game
	 * @param time
	 */
	public void addTime(float time) {
		if (time>0) {
			score_ += time*MULT_;
		}
	}
	
	
	/**
	 * Reset the score
	 */
	public void reset() {
		score_ = 0;
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
	private static final int MULT_ = 5;
}
