package com.oddfry.logic;

import com.oddfry.globals.Globals;

public class RuleGenerator {

	/* PUBLIC */
	/*		CLASS */
	/**
	 * Get next rule
	 */
	public void next() {
		switch(Globals.GetInstance().getRand().nextInt(4)) {
		case 0:
			currentRule_ = new RuleCorners();
			break;
		case 1:
			currentRule_ = new RuleCircle();
			break;
		case 2:
			currentRule_ = new RuleTimeBehavior();
			break;
		case 3:
			currentRule_ = new RuleDirection();
			break;
		default:
			currentRule_ = new RuleMenu();
			break;
		}
	}


	/**
	 * Reset, start rules for menu
	 */
	public void reset() {
		currentRule_ = new RuleMenu();
	}


	/**
	 * Getter
	 * @return
	 */
	public Rule getRule() {
		return currentRule_;
	}


	/*		STATIC */
	synchronized public static RuleGenerator GetInstance() {
		if (INSTANCE_ == null) {
			INSTANCE_ = new RuleGenerator();
		}
		return INSTANCE_;
	}


	/* PRIVATE */
	/*		CLASS */
	private Rule currentRule_;


	/**
	 * Constructor
	 */
	private RuleGenerator() {
		currentRule_ = new RuleMenu();
	}


	/*		STATIC */
	private static RuleGenerator INSTANCE_;
}
