package com.oddfry.graphics;

import java.util.HashMap;

/**
 * Container for grids</br>
 * Singleton
 * 
 * @author Guillaume Berard
 *
 */
public class GridContainer {
	/* PUBLIC */
	/*		CLASS */
	public Grid getGrid(int res) {
		if ( grids_.containsKey(res) ) {
			return grids_.get(res);
		} else {
			Grid grid = new Grid(res);
			grids_.put(res, grid);
			return grid;
		}
	}
	
	
	/*		STATIC */
	synchronized public static GridContainer GetInstance() {
		if (INSTANCE_ == null) {
			INSTANCE_ = new GridContainer();
		}
		return INSTANCE_;
	}
	
	
	/* PRIVATE */
	/*		CLASS */
	private HashMap<Integer, Grid> grids_;
	
	
	/**
	 * Constructor
	 */
	private GridContainer() {
		grids_ = new HashMap<Integer, Grid>();
	}
	
	
	/*		STATIC */
	private static GridContainer INSTANCE_;
}
