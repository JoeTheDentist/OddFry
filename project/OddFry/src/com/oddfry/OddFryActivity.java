package com.oddfry;

import com.oddfry.globals.Globals;
import com.oddfry.globals.ResourcesUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;


/**
 * Main activity for the video game "The Odd Fry"
 * 
 * @author Guillaume Berard
 *
 */
public class OddFryActivity extends Activity {
	
	/* PUBLIC */
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ResourcesUtil.SetActivity(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(	WindowManager.LayoutParams.FLAG_FULLSCREEN,
        						WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Globals.GetInstance();
        Globals.GetInstance().setMenu();
    }
    
    
    /* PROTECTED */
    @Override
	protected void onDestroy() {
		super.onDestroy();
		//Brutal but it works
		android.os.Process.killProcess(android.os.Process.myPid());
	}
    
}