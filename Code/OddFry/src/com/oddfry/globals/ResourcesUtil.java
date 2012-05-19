package com.oddfry.globals;

import com.oddfry.graphics.Screen;

import android.app.Activity;

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
	
	
	/**
	 * Setter
	 * @param screen
	 */
	public static void SetScreen(Screen screen) {
		SCREEN_ = screen;
	}
	
	
	/**
	 * Getter
	 * @param screen
	 */
	public static Screen GetScreen() {
		return SCREEN_;
	}
	
	
	/* PRIVATE */
	private static Activity ACTIVITY_;
	private static Screen SCREEN_;
}
