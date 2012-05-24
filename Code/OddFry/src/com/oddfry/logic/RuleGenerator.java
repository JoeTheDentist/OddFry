package com.oddfry.logic;

public class RuleGenerator {
	
	/* PUBLIC */
	/*		CLASS */
	/**
	 * Get next rule
	 */
	public void next() {
		//TODO
	}
	
	
	/**
	 * Reset, start rules for menu
	 */
	public void reset() {
		//TODO
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
