package com.oddfry.graphics;

import java.util.LinkedList;

import com.oddfry.controls.Controlled;
import com.oddfry.globals.Globals;
import com.oddfry.globals.ResourcesUtil;


/**
 * Menu
 * 
 * @author Guillaume Berard
 *
 */
public class Menu implements Controlled {
	
	/* PUBLIC */
	/**
	 * Constructor
	 */
	public Menu() {
		menus_ = new LinkedList<String>();
		menus_.add("Play now!");
		menus_.add("Quit");
	}
	
	
	/**
	 * Draw the menu
	 */
	public void draw() {
		ResourcesUtil.GetScreen().drawMenu(menus_);
	}
	
	
	/**
	 * Point the menu
	 * @param x
	 * @param y
	 */
	public void point(float x, float y) {
		switch (ResourcesUtil.GetScreen().choiceMenu(menus_, x, y)) {
		case 0:
			Globals.GetInstance().setGame();
			break;
		case 1:
			Globals.GetInstance().stopApp();
			break;
		default:
			break;	
		}
	}
	
	
	/* PRIVATE */
	private LinkedList<String> menus_;
}
