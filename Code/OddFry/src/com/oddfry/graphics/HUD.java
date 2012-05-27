package com.oddfry.graphics;

import com.oddfry.logic.Score;
import com.oddfry.logic.Time;

/**
 * Graphics for foreground, time, score and transition message.</br>
 * It lives only in game.</br>
 * Print in white time and score, if the time is negative,
 * it will be displayed in red.
 * 
 * @author Guillaume Berard
 *
 */
public class HUD {
	
	/* PUBLIC */
	/**
	 * Constructor
	 */
	public HUD() {
		score_ = Score.GetInstance();
		time_ = Time.GetInstance();
	}
	
	
	/**
	 * Draw score and time
	 */
	public void draw() {
		Screen.GetInstance().drawTextLeft(Integer.toString(score_.getScore()), false);
		Screen.GetInstance().drawTextRight(Integer.toString(time_.getTimeLeft()), time_.getTimeLeft() < 0);
	}
	
	
	/* PRIVATE */
	private Score score_;
	private Time time_;
}
