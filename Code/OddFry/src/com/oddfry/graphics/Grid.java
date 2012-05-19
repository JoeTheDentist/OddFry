package com.oddfry.graphics;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/**
 * Class that stores a full image into an array
 * of images
 * 
 * @author Guillaume Berard
 *
 */
public class Grid {
	
	/* PUBLIC */
	/**
	 * Constructor<br/>
	 * Create an array of images with one image<br/>
	 * Warning, all the images in the full image must be
	 * delimited by one pixel width of pink 0xFF00FF. Be sure that the 0xFF00FF
	 * is only used for delimit the box.
	 * @param imgId
	 */
	public Grid(int imgId) {
		fullImage_ = new Image(imgId);
		
		//Search the first occurrence of pink
		for ( int i=1; i<fullImage_.getBitmap().getBitmap().getWidth(); i++ ) {
			if ( fullImage_.getBitmap().getBitmap().getPixel(i,1) == -65281 ) {
				width_ = i-1;
				break;
			}
		}
		for ( int j=1; j<fullImage_.getBitmap().getBitmap().getHeight(); j++ ) {
			if ( fullImage_.getBitmap().getBitmap().getPixel(1,j) == -65281 ) {
				height_ = j-1;
				break;
			}
		}
		int ver = (int) ((int)fullImage_.h()/(height_+2)) ;
		int hor = (int) ((int)fullImage_.w()/(width_+2));
		
		nbImg_ = ver*hor;
		grid_ = new Image[nbImg_];
		for (int i=0; i<ver; i++) {
			for (int j=0; j<hor; j++) {
				BitmapDrawable currBitmap = new BitmapDrawable(
						Bitmap.createBitmap(fullImage_.getBitmap().getBitmap(),
								(int)(1+j*(width_+2)), (int)(1+i*(height_+2)), (int)width_, (int)height_, null, true));
				grid_[i*hor+j] = new Image(currBitmap);
			}
		}
	}
	
	/**
	 * Get the image at position id
	 * @param id
	 * @return image at id
	 */
	public Image getImage(int id) {
		return grid_[id%nbImg_];
	}
	
	
	/**
	 * Getter
	 * @return height of an image
	 */
	public float boxH() {
		return height_;
	}
	
	
	/**
	 * Getter
	 * @return width of an image
	 */
	public float boxW() {
		return width_;
	}
	
	
	/**
	 * Getter
	 * @return full image
	 */
	public Image getFullImage() {
		return fullImage_;
	}
	
	
	/**
	 * Getter
	 * @return number of images
	 */
	public int getSize() {
		return nbImg_;
	}
	
	
	/* PRIVATE */
	private Image fullImage_;
	private Image grid_[];
	private int nbImg_;
	private float height_;
	private float width_;
}
