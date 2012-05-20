package com.oddfry.graphics;

import java.util.LinkedList;

import com.oddfry.globals.ResourcesUtil;


/**
 * Menu
 * 
 * @author Guillaume Berard
 *
 */
public class Menu {
	
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
	
	
	/* PRIVATE */
	private LinkedList<String> menus_;
}
