package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.game.entities.*;
import com.mygdx.game.systems.*;

import java.util.ArrayList;

/**
 * Main class of the game which manages the creation
 * of entities and systems, and then the execution of
 * the systems on those entities.
 */
public class MyGdxGame extends ApplicationAdapter {
	ArrayList<Entity> entities;
	SystemUpdateInput updateInputSystem;
	SystemUpdateVelocityByInput updateVelocityByInputSystem;
	SystemUpdatePositionByVelocity updatePositionByVelocitySystem;
	SystemCollision collisionSystem;
	SystemRender renderSystem;

	/**
	 * Creates entities and systems.
	 */
	@Override
	public void create() {
        entities = new ArrayList<>();
		entities.add(new Map(0,0, Gdx.graphics.getHeight(), Gdx.graphics.getWidth())); //currently the map's sprite size is 3000 x 1896
		entities.add(new Player());

//		entities.add(new Library(90, 300,50, 100));
//		entities.add(new DuckPond(300,300, 100,100));
//		entities.add(new Piazza(300,300, 100,100));
//		entities.add(new Accommodation(300,300, 100,100));

		entities.add(new Library(1100, 550,50, 100)); //square may be a 50 pixel change
		entities.add(new DuckPond(1700,700, 100,100));
		entities.add(new Piazza(2050,1100, 100,100));
		entities.add(new Accommodation(1200,1900, 100,100));


		updateInputSystem = new SystemUpdateInput();
		updateVelocityByInputSystem = new SystemUpdateVelocityByInput();
		updatePositionByVelocitySystem = new SystemUpdatePositionByVelocity();
		collisionSystem = new SystemCollision();
		renderSystem = new SystemRender();
	}

	/**
	 * Clear screen and then update all systems.
	 * This is called every frame.
	 */
	@Override
	public void render() {

		// Turn the screen black.
		ScreenUtils.clear(0, 0, 0, 1);

		// updates all the systems every frame
		UpdateFrame();

	}

	/**
	 * Update each system.
	 */
	void UpdateFrame() {
		updateInputSystem.update(entities);
		updateVelocityByInputSystem.update(entities);
		updatePositionByVelocitySystem.update(entities);
		collisionSystem.update(entities);
		renderSystem.update(entities);

	}

	@Override
	public void dispose() {
		//disposes of all used assets when game is finshed
		renderSystem.dispose(entities);
	}

	public void resize(ArrayList<Entity> entities, int width, int height) {
		//Updates window when screen is resized
		renderSystem.resize(entities, width, height);
	}
}
