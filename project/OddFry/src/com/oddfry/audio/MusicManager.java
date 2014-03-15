package com.oddfry.audio;

import com.oddfry.R;
import com.oddfry.globals.ResourcesUtil;

import android.media.MediaPlayer;

/**
 * Manage the music</br>
 * Singleton
 * 
 * @author Guillaume Berard
 *
 */
public class MusicManager {
	/* PUBLIC */
	/*		CLASS */
	public void setMenuMusicOnce() {
		if (lastWasGame_) {
			lastWasGame_ = false;
			if (player_ != null) {
				player_.stop();
			}
			player_ = MediaPlayer.create(ResourcesUtil.GetActivity(), R.raw.odd_fry_menu);
			player_.start();
			player_.setLooping(true);
		}
	}
	
	
	public void setGameMusicOnce() {
		if (!lastWasGame_) {
			lastWasGame_ = true;
			if (player_ != null) {
				player_.stop();
			}
			player_ = MediaPlayer.create(ResourcesUtil.GetActivity(), R.raw.odd_fry);
			player_.start();
			player_.setLooping(true);
		}
	}
	
	
	/*		STATIC */
	/**
	 * Getter
	 * @return instance
	 */
	public static MusicManager GetInstance() {
		if (INSTANCE_ == null) {
			INSTANCE_ = new MusicManager();
		}
		return INSTANCE_;
	}
	
	
	/* PRIVATE */
	/*		CLASS */
	private boolean lastWasGame_ = true;
	private MediaPlayer player_;
	
	
	/**
	 * Constructor
	 */
	private MusicManager() {
		
	}
	
	
	/*		STATIC */
	private static MusicManager INSTANCE_;
}
