package com.oddfry.graphics;

import com.oddfry.globals.ResourcesUtil;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Screen which displays pictures on the modile screen
 * 
 * @author Guillaume Berard
 *
 */
public class Screen extends SurfaceView implements
	SurfaceHolder.Callback {

	/* PUBLIC */
	/**
	 * Constructor
	 * @param context
	 */
	public Screen(Context context) {
		super(context);
		ResourcesUtil.GetActivity().setContentView(this);
		ResourcesUtil.SetScreen(this);
		getHolder().addCallback(this);
		setFocusable(true);
	}


	/**
	 * Lock the screen, ready to draw
	 */
	public void lock() {
		canvas_ = getHolder().lockCanvas();
	}


	/**
	 * Unlock the screen can't draw anymore
	 */
	public void unlock() {
		if ( canvas_ != null) {
			getHolder().unlockCanvasAndPost(canvas_);
			canvas_ = null;
		}
	}


	/**
	 * Interface
	 */
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO
	}


	/**
	 * Interface
	 */
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO
	}


	/**
	 * Interface
	 */
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO
	}


	/* PACKAGE */
	void drawImage(Image img, float x, float y) {
		if (canvas_ != null) {
			canvas_.drawBitmap(img.getBitmap().getBitmap(), x, y, null);
		} else {
			Log.e("Screen", "### Can't draw");
		}
	}


	/* PRIVATE */
	private Canvas canvas_;
}
