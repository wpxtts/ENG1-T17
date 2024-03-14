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

public class MyGdxGame extends ApplicationAdapter {
	ArrayList<Entity> entities;
	SystemUpdateInput updateInputSystem;
	SystemUpdateVelocityByInput updateVelocityByInputSystem;
	SystemUpdatePositionByVelocity updatePositionByVelocitySystem;
	SystemCollision collisionSystem;
	SystemRender renderSystem;

	@Override
	public void create() {

		entities = new ArrayList<>();
		entities.add(new Player());

		entities.add(new Block(90, 350,100, 100, true));
		entities.add(new Block(300,300, 100,100, false));

		updateInputSystem = new SystemUpdateInput();
		updateVelocityByInputSystem = new SystemUpdateVelocityByInput();
		updatePositionByVelocitySystem = new SystemUpdatePositionByVelocity();
		collisionSystem = new SystemCollision();
		renderSystem = new SystemRender();
	}

	@Override
	public void render() {

		// Turn the screen black.
		ScreenUtils.clear(0, 0, 0, 1);

		// updates all the systems every frame
		UpdateFrame();

	}
	void UpdateFrame() {

		updateInputSystem.Update(entities);
		updateVelocityByInputSystem.Update(entities);
		updatePositionByVelocitySystem.Update(entities);
		collisionSystem.Update(entities);
		renderSystem.Update(entities);

	}
}
