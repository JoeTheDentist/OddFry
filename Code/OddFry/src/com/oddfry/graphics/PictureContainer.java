package com.oddfry.graphics;

import java.io.InputStream;
import java.util.HashMap;

import com.oddfry.globals.ResourcesUtil;

import android.graphics.drawable.BitmapDrawable;

/**
 * Container for all used bitmaps
 * 
 * @author Guillaume Berard
 *
 */
public class PictureContainer {
	
	/* PUBLIC */
	/**
	 * Constructor
	 */
	public PictureContainer() {
		images_ = new HashMap<Integer, BitmapDrawable>();
	}
	
	
	/**
	 * Getter
	 * @param image
	 * @return
	 */
	BitmapDrawable getImage(int image) {
		if ( images_.containsKey(image) ) {
			return images_.get(image);
		} else {
			//Faire comme ca... sinon pas la bonne taille
			InputStream is = ResourcesUtil.GetActivity().getResources().openRawResource(image);
			BitmapDrawable bd = new BitmapDrawable(is);
			return bd;
		}
	}
	
	
	/* PRIVATE */
	private HashMap<Integer, BitmapDrawable> images_;
}
