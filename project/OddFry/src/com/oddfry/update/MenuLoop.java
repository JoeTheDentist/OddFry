package com.oddfry.update;

import com.oddfry.actors.FriesCrowd;
import com.oddfry.audio.MusicManager;
import com.oddfry.controls.MenuController;
import com.oddfry.graphics.Background;
import com.oddfry.graphics.Menu;

/**
 * Loop which refreshes the menu
 * 
 * @author Guillaume Berard
 *
 */
public class MenuLoop extends UpdateLoop {
	
	/* PUBLIC */
	/**
	 * Constructor
	 */
	public MenuLoop() {
		MusicManager.GetInstance().setMenuMusicOnce();
		back_ = new Background();
		fries_ = new FriesCrowd();
		menu_ = new Menu();
		MenuController controller = new MenuController();
		controller.setTarget(menu_);
	}
	
	
	/* PROTECTED */
	@Override
	final protected void update() {
		getScreen().lock();
		back_.draw();
		fries_.move();
		fries_.draw();
		menu_.draw();
		getScreen().unlock();
	}

	
	@Override
	protected void postUpdate() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	/* PRIVATE */
	private FriesCrowd fries_;
	private Background back_;
	private Menu menu_;
}
