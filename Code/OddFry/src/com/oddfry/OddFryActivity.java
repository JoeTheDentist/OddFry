package com.oddfry;

import com.oddfry.globals.Globals;
import com.oddfry.globals.ResourcesUtil;

import android.app.Activity;
import android.os.Bundle;


/**
 * Main activity for the video game "The Odd Fry"
 * 
 * @author Guillaume Berard
 *
 */
public class OddFryActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ResourcesUtil.SetActivity(this);
        Globals.GetInstance();
        Globals.GetInstance().setMenu();
        Globals.GetInstance().run();
    }
    
    
    @Override
	protected void onDestroy() {
		super.onDestroy();
		//Brutal but it works
		android.os.Process.killProcess(android.os.Process.myPid());
	}
}