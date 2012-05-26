package com.oddfry.globals;

import com.oddfry.logic.RuleGenerator;
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
		getGame().win();
	}
	
	
	/**
	 * Loose
	 */
	public void lose() {
		getGame().lose();
	}
	
	
	/**
	 * Next, if win new level, if loose menus
	 */
	public void next() {
		if (getGame().hasWon()) {
			setGame();
		} else if (getGame().hasLost()) {
			RuleGenerator.GetInstance().reset();
			setMenu();
		}
	}
	
	
	/**
	 * Get current game time
	 * @return current time in milliseconds
	 */
	public int getTime() {
		return (int) System.currentTimeMillis();
	}
	
	
	/**
	 * Getter
	 * @return game, if created
	 */
	public GameLoop getGame() {
		return (GameLoop)loop_;
	}
	
	
	/**
	 * Get delta time
	 * @return delta time
	 */
	public float getDt() {
		return loop_.getDt();
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
