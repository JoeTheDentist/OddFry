package com.oddfry.graphics;

import java.util.List;

import com.oddfry.globals.ResourcesUtil;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
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
		h_ = ResourcesUtil.GetActivity().getWindowManager().getDefaultDisplay().getHeight();
		w_ = ResourcesUtil.GetActivity().getWindowManager().getDefaultDisplay().getWidth();
		menuPaint_ = new Paint();
		menuPaint_.setColor(Color.RED);
		menuPaint_.setStyle(Style.FILL);
		menuPaint_.setTextSize(100);
		normalTextPaint_ = new Paint();
		normalTextPaint_.setColor(Color.WHITE);
		normalTextPaint_.setStyle(Style.FILL);
		normalTextPaint_.setTextSize(20);
		warningTextPaint_ = new Paint();
		warningTextPaint_.setColor(Color.RED);
		warningTextPaint_.setStyle(Style.FILL);
		warningTextPaint_.setTextSize(20);
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
	 * Getter
	 * @return height
	 */
	public float getH() {
		return h_;
	}

	
	/**
	 * Getter
	 * @return width
	 */
	public float getW() {
		return w_;
	}

	
	/**
	 * Interface
	 */
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {}


	/**
	 * Interface
	 */
	public void surfaceCreated(SurfaceHolder holder) {}


	/**
	 * Interface
	 */
	public void surfaceDestroyed(SurfaceHolder holder) {}


	/* PACKAGE */
	/**
	 * Draw the image at the given position
	 * @param img
	 * @param x
	 * @param y
	 */
	void drawImage(Image img, float x, float y) {
		if (canvas_ != null) {
			canvas_.drawBitmap(img.getBitmap().getBitmap(), x, y, null);
		} else {
			Log.e("Screen", "### Can't draw");
		}
	}
	
	
	/**
	 * Draw the item in the menu a the middle of the screen
	 * @param menu
	 */
	void drawMenu(List<String> menu) {
		//TODO real pos
		if (canvas_ != null) {
			int pos = 100;
			for (String s : menu) {
				canvas_.drawText(s, 10, pos, menuPaint_);
				pos += 100;
			}
		} else {
			Log.e("Screen", "### Can't draw");
		}
	}


	/* PRIVATE */
	private Canvas canvas_;
	private Paint menuPaint_;
	private Paint normalTextPaint_;
	private Paint warningTextPaint_;
	private float h_;
	private float w_;
}
