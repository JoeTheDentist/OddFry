package com.oddfry.update;

import com.oddfry.actors.FriesCrowd;
import com.oddfry.controls.GameController;
import com.oddfry.graphics.Background;

/**
 * Loop which refreshes the game
 * 
 * @author Guillaume Berard
 *
 */
public class GameLoop extends UpdateLoop {

	/* PUBLIC */
	/**
	 * Constructor
	 */
	public GameLoop() {
		back_ = new Background();
		fries_ = new FriesCrowd();
		GameController controller = new GameController();
		fries_.setController(controller);
	}
	
	
	/**
	 * Loose
	 */
	public void loose() {
		loose_ = true;
		msg_ = "You Loose";
	}
	
	
	/**
	 * Win
	 */
	public void win() {
		win_ = true;
		msg_ = "You Win";
	}
	
	
	/* PROTECTED */
	@Override
	final protected void update() {
		getScreen().lock();
		back_.draw();
		fries_.move();
		fries_.draw();
		if ( loose_ || win_ ) {
			getScreen().drawTextCenter(msg_);
		}
		getScreen().unlock();
	}

	
	@Override
	protected void postUpdate() {
		//TODO real loop
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	/* PRIVATE */
	private FriesCrowd fries_;
	private Background back_;
	private boolean loose_ = false;
	private boolean win_ = false;
	private String msg_;
}
