package com.oddfry.update;

import com.oddfry.actors.FriesCrowd;
import com.oddfry.audio.MusicManager;
import com.oddfry.controls.Controlled;
import com.oddfry.controls.GameController;
import com.oddfry.globals.Globals;
import com.oddfry.graphics.Background;
import com.oddfry.graphics.HUD;
import com.oddfry.logic.Rule;
import com.oddfry.logic.RuleGenerator;
import com.oddfry.logic.Score;
import com.oddfry.logic.Time;

/**
 * Loop which refreshes the game
 * 
 * @author Guillaume Berard
 *
 */
public class GameLoop extends UpdateLoop implements Controlled {

	/* PUBLIC */
	/**
	 * Constructor
	 */
	public GameLoop() {
		RuleGenerator.GetInstance().next();
		MusicManager.GetInstance().setGameMusicOnce();
		//TODO calc time decrease ?
		time_.setTime(RuleGenerator.GetInstance().getRule().getTimeToSolve());
		hud_ = new HUD();
		back_ = new Background();
		fries_ = new FriesCrowd();
		GameController controller = new GameController();
		controller.setTarget(this);
	}


	/**
	 * Loose
	 */
	public void lose() {
		lose_ = true;
		msg_ = "You Lose";
		Score.GetInstance().reset();
	}


	/**
	 * Win
	 */
	public void win() {
		win_ = true;
		msg_ = "You Win";
		score_.addTime(time_.getTimeLeft());
	}


	/**
	 * Getter
	 * @return Current rule
	 */
	public Rule getRule() {
		return rule_;
	}


	/**
	 * Getter
	 * @return if the level is won
	 */
	public boolean hasWon() {
		return win_;
	}


	/**
	 * Getter
	 * @return if the level is lost
	 */
	public boolean hasLost() {
		return lose_;
	}


	/**
	 * When point the screen
	 * @param x
	 * @param y
	 */
	public void point(float x, float y) {
		if (!win_ && !lose_) {
			if (fries_.touched(x, y)) {
				Globals.GetInstance().win();
			} else {
				Globals.GetInstance().lose();
			}
		} else {
			Globals.GetInstance().next();
		}
	}


	/* PROTECTED */
	@Override
	final protected void update() {
		lastTimeUpdate_ = Globals.GetInstance().getTime();
		fries_.move();
		if (!skip_) {
			getScreen().lock();
			back_.draw();
			fries_.draw();
			if ( lose_ || win_ ) {
				getScreen().drawTextCenter(msg_);
			} else {
				time_.update();
				score_.update();
				hud_.draw();
			}
			getScreen().unlock();
		} else {
			skip_ = false;
		}
	}


	@Override
	protected void postUpdate() {
		float timeUpdate = Globals.GetInstance().getTime() - lastTimeUpdate_;
		try {
			if (TIMECYCLE_-timeUpdate > 0) {
				Thread.sleep((long) (TIMECYCLE_-timeUpdate));
			} else {
				skip_ = true;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	/* PRIVATE */
	/*		CLASS */
	private float lastTimeUpdate_;
	private boolean skip_ = false;
	private FriesCrowd fries_;
	private Background back_;
	private Rule rule_ = RuleGenerator.GetInstance().getRule();
	private Score score_ = Score.GetInstance();
	private Time time_ = Time.GetInstance();
	private HUD hud_;
	private boolean lose_ = false;
	private boolean win_ = false;
	private String msg_;


	/*		STATIC */
	private static final float TIMECYCLE_ = 50;
}
