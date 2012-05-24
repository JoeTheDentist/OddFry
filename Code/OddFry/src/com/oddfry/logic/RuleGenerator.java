package com.oddfry.logic;

public class RuleGenerator {
	
	/* PUBLIC */
	/*		CLASS */
	/**
	 * 
	 */
	public void next() {
		
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
