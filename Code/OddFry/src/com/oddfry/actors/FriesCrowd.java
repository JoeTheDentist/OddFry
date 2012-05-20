package com.oddfry.actors;

import java.util.LinkedList;
import java.util.Random;

import com.oddfry.globals.Globals;
import com.oddfry.globals.ResourcesUtil;

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
		int numberOfFries = (int) ((DENSISTY_*ResourcesUtil.GetScreen().getH()*
				ResourcesUtil.GetScreen().getW()) / 1000000);
		Random rand = new Random(Globals.GetInstance().getTime());
		for (int i=0; i<numberOfFries; i++) {
			NormalFry fry = new NormalFry();
			fry.setX(rand.nextFloat()*ResourcesUtil.GetScreen().getW());
			fry.setY(rand.nextFloat()*ResourcesUtil.GetScreen().getH());
			fries_.add(fry);
		}
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
	/*		CLASS */
	private LinkedList<NormalFry> fries_;
	
	
	/**
	 * Sort fires according to their y-level
	 */
	private void sortFries() {
		//TODO sort
	}
	
	
	/*		STATIC */
	private float DENSISTY_ = 100; //number of fries in 1 kpixels²
}
