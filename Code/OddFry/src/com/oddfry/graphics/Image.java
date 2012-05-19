package com.oddfry.graphics;

import android.graphics.drawable.BitmapDrawable;


/**
 * Wrapper for bitmaps
 * 
 * @author Guillaume Berard
 *
 */
public class Image {
	
	/* PUBLIC */
	/**
	 * Constructor
	 * @param bitmap
	 */
	public Image(BitmapDrawable b) {
		image_ = b;
	}
	
	
	/**
	 * Constructor
	 * @param resources
	 */
	public Image(int i) {
		image_ = PC.getImage(i);
	}
	
	
	/**
	 * Getter
	 * @return bitmap
	 */
	BitmapDrawable getBitmap() {
		return image_;
	}

	
	/**
	 * Getter
	 * @return height
	 */
	public float h() {
		return (float)image_.getBitmap().getHeight();
	}
	
	
	/**
	 * Getter
	 * @return width
	 */
	public float w() {
		return (float)image_.getBitmap().getWidth();
	}

	
	/* PRIVATE */
	/*		CLASS */
	private BitmapDrawable image_;
	
	
	/*		STATIC */
	private static PictureContainer PC = PictureContainer.GetInstance();
}
