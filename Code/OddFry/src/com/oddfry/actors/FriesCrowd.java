package com.oddfry.actors;

import java.util.LinkedList;

/**
 * All the normal fries.</br>
 * The number of fries depends on the size of the screen.</br>
 * All positions are set randomly.
 * 
 * @author Guillaume Berard
 *
 */
public class FriesCrowd {
	
	/* PUBLIC */
	/**
	 * Constructor
	 */
	public FriesCrowd() {
		fries_ = new LinkedList<NormalFry>();
		//TODO gen
	}
	
	
	/**
	 * Draw all fries, according to their y-level
	 */
	public void draw() {
		sortFries();
		for (NormalFry fry : fries_) {
			fry.draw();
		}
	}
	
	
	/* PRIVATE */
	private LinkedList<NormalFry> fries_;
	
	
	/**
	 * Sort fires according to their y-level
	 */
	private void sortFries() {
		//TODO sort
	}
}
