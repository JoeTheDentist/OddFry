package com.oddfry.graphics;

import java.io.InputStream;
import java.util.HashMap;

import com.oddfry.globals.ResourcesUtil;

import android.graphics.drawable.BitmapDrawable;

/**
 * Container for all used bitmaps</br>
 * Singleton
 * 
 * @author Guillaume Berard
 *
 */
public class PictureContainer {
	
	/* PUBLIC */
	/*		CLASS */
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
	
	
	/*		STATIC */
	synchronized public static PictureContainer GetInstance() {
		if (INSTANCE_ == null) {
			INSTANCE_ = new PictureContainer();
		}
		return INSTANCE_;
	}
	
	
	/* PRIVATE */
	/*		CLASS */
	private HashMap<Integer, BitmapDrawable> images_;
	
	
	/**
	 * Constructor
	 */
	private PictureContainer() {
		images_ = new HashMap<Integer, BitmapDrawable>();
	}
	
	/*		STATIC */
	static PictureContainer INSTANCE_;
}
