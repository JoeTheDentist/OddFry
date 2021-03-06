package com.oddfry.actors;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import com.oddfry.graphics.Screen;
import com.oddfry.logic.RuleGenerator;

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
		fries_ = new LinkedList<Actor>();
		int numberOfFries = (int) ((DENSISTY_*Screen.GetInstance().getH()*
				Screen.GetInstance().getW()) / 1000000);
		Random rand = new Random();
		for (int i=0; i<numberOfFries; i++) {
			NormalFry fry = new NormalFry();
			fry.setX(rand.nextFloat()*Screen.GetInstance().getW());
			fry.setY(rand.nextFloat()*Screen.GetInstance().getH());
			fries_.add(fry);
		}
		oddFry_ = new OddFry();
		oddFry_.setX(RuleGenerator.GetInstance().getRule().getX());
		oddFry_.setY(RuleGenerator.GetInstance().getRule().getY());
		fries_.add(oddFry_);
	}
	
	
	/**
	 * Draw all fries, according to their y-level
	 */
	public void draw() {
		sortFries();
		for (Actor fry : fries_) {
			fry.draw();
		}
	}
	
	
	/**
	 * Move all the fries
	 */
	public void move() {
		for (Actor fry : fries_) {
			fry.move();
		}
	}
	
	
	/**
	 * Touched?
	 * @param x
	 * @param y
	 * @return if touched or not
	 */
	public boolean touched(float x, float y) {
		return oddFry_.touched(x, y);
	}
	
	
	/* PRIVATE */
	/*		CLASS */
	private LinkedList<Actor> fries_;
	private OddFry oddFry_;
	
	
	/**
	 * Sort fires according to their y-level
	 */
	private void sortFries() {
		Collections.sort(fries_);
	}
	
	
	/*		STATIC */
	private float DENSISTY_ = 100; //number of fries in 1 kpixels�
}
