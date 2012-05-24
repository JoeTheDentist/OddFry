package com.oddfry.globals;

import android.app.Activity;

/**
 * Resources
 * 
 * @author Guillaume Berard
 *
 */
public class ResourcesUtil {
	/* PUBLIC */
	/**
	 * Setter
	 * @param activity
	 */
	public static void SetActivity(Activity activity) {
		ACTIVITY_ = activity;
	}
	
	
	/**
	 * Getter
	 * @param activity
	 */
	public static Activity GetActivity() {
		return ACTIVITY_;
	}
	
	
	/* PRIVATE */
	private static Activity ACTIVITY_;
}
