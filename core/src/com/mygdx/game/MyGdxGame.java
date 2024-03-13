package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.entities.Block;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.Player;
import com.mygdx.game.systems.*;

import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {
	ArrayList<Entity> entities;

	SystemUpdateInput inputUpdateSystem;
	SystemUpdateVelocityByInput updateVelocityByInputSystem;
	SystemUpdatePositionByVelocity updatePositionByVelocitySystem;
	SystemCollision collisionSystem;
	SystemRender renderSystem;

	@Override
	public void create() {
		// List of entities
		entities = new ArrayList<>();

		// Player entity
		entities.add(new Player());

		// Block Entity
		entities.add(new Block(300,300,100, 100, false));

		// Block entity
		entities.add(new Block(50, 500, 100, 100, true));

		inputUpdateSystem = new SystemUpdateInput();
		updateVelocityByInputSystem = new SystemUpdateVelocityByInput();
		updatePositionByVelocitySystem = new SystemUpdatePositionByVelocity();
		collisionSystem = new SystemCollision();
		renderSystem = new SystemRender();
	}

	@Override
	public void render() {

		// Turn the screen black.
		ScreenUtils.clear(0, 0, 0, 1);

		// updates all the systems this frame.
		inputUpdateSystem.Update(entities);
		updateVelocityByInputSystem.Update(entities);
		updatePositionByVelocitySystem.Update(entities);
//		playerControllerSystem.Update(entities);
		collisionSystem.Update(entities);
		renderSystem.Update(entities);

	}

}
