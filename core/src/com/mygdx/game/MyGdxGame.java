package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.screens.MainScreen;
import com.mygdx.game.screens.Screen;

/**
 * Main class of the game which manages the creation
 * of entities and systems, and then the execution of
 * the systems on those entities.
 */
public class MyGdxGame extends ApplicationAdapter {
//	ArrayList<Entity> entities;
//	SystemUpdateInput updateInputSystem;
//	SystemUpdateVelocityByInput updateVelocityByInputSystem;
//	SystemUpdatePositionByVelocity updatePositionByVelocitySystem;
//	SystemCollision collisionSystem;
//	SystemRender renderSystem;
	Screen currentScreen;
	/**
	 * Creates entities and systems.
	 */
	@Override
	public void create() {
		currentScreen = new MainScreen();
		currentScreen.create();
	}
	/**
	 * Clear screen and then update all systems.
	 * This is called every frame.
	 */
	@Override
	public void render() {
		this.updateFrame();
		currentScreen.render();

	}

	/**
	 * Update each system.
	 */
	void updateFrame() {
		Screen newScreen = currentScreen.updateFrame();
		if(newScreen!=null){
			this.changeScreen(newScreen);
		}

	}
	// To change screen
	void changeScreen(Screen newScreen){
		currentScreen = newScreen;
		currentScreen.create();
	}
}
