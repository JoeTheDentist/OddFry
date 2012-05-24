package com.oddfry.graphics;

import java.util.List;

import com.oddfry.controls.ControlsManager;
import com.oddfry.globals.ResourcesUtil;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Screen which displays pictures on the modile screen</br>
 * Singleton
 * 
 * @author Guillaume Berard
 *
 */
public class Screen extends SurfaceView implements
SurfaceHolder.Callback {

	/* PUBLIC */
	/*		CLASS */
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


	@Override
	public boolean onTouchEvent (MotionEvent event) {
		controls_.touch(event);
		return true;
	}


	/**
	 * Draw the item in the menu a the middle of the screen
	 * @param menu
	 */
	public void drawTextCenter(String text) {
		if (canvas_ != null) {
			canvas_.drawText(text, 10, getH()/2, menuPaint_);
		} else {
			Log.e("Screen", "### Can't draw");
		}
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


	/*		STATIC */
	/**
	 * Getter
	 * @return instance
	 */
	synchronized public static Screen GetInstance() {
		if (INSTANCE_ == null) {
			INSTANCE_ = new Screen();
		}
		return INSTANCE_;
	}


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
				pos += 150;
			}
		} else {
			Log.e("Screen", "### Can't draw");
		}
	}


	/**
	 * Draw text on top right
	 * @param msg
	 * @param warning
	 */
	void drawTextRight(String msg, boolean warning) {
		if (canvas_ != null) {
			//TODO pos, warning
			canvas_.drawText(msg, 0, 0, normalTextPaint_);
		} else {
			Log.e("Screen", "### Can't draw");
		}
	}


	/**
	 * Draw text on top left
	 * @param msg
	 * @param warning
	 */
	void drawTextLeft(String msg, boolean warning) {
		//TODO pos, warning
		if (canvas_ != null) {
			canvas_.drawText(msg, 0, 0, warningTextPaint_);
		} else {
			Log.e("Screen", "### Can't draw");
		}
	}



	int choiceMenu(List<String> menu, float x, float y) {
		//TODO better
		if (y > 10 && y < 200) {
			return 0;
		} else if ( y > 200 && y < 400) {
			return 1;
		} else {
			return -1;
		}
	}


	/* PRIVATE */
	/*		CLASS */
	private ControlsManager controls_ = ControlsManager.GetInstance();
	private Canvas canvas_;
	private Paint menuPaint_;
	private Paint normalTextPaint_;
	private Paint warningTextPaint_;
	private float h_;
	private float w_;


	/**
	 * Constructor
	 * @param context
	 */
	private Screen() {
		super(ResourcesUtil.GetActivity());
		h_ = ResourcesUtil.GetActivity().getWindowManager().getDefaultDisplay().getHeight();
		w_ = ResourcesUtil.GetActivity().getWindowManager().getDefaultDisplay().getWidth();
		menuPaint_ = new Paint();
		menuPaint_.setColor(Color.RED);
		menuPaint_.setStyle(Style.FILL);
		menuPaint_.setTextSize(100);
		menuPaint_.setTypeface(Typeface.MONOSPACE);
		normalTextPaint_ = new Paint();
		normalTextPaint_.setColor(Color.WHITE);
		normalTextPaint_.setStyle(Style.FILL);
		normalTextPaint_.setTextSize(20);
		normalTextPaint_.setTypeface(Typeface.MONOSPACE);
		warningTextPaint_ = new Paint();
		warningTextPaint_.setColor(Color.RED);
		warningTextPaint_.setStyle(Style.FILL);
		warningTextPaint_.setTextSize(20);
		normalTextPaint_.setTypeface(Typeface.MONOSPACE);
		ResourcesUtil.GetActivity().setContentView(this);
		getHolder().addCallback(this);
		setFocusable(true);
	}


	/*		STATIC */
	private static Screen INSTANCE_;
}
