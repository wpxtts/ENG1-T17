package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MyGdxGame extends ApplicationAdapter {
	Entity[] entities;
	ComponentPlayerController player;

	SystemPlayerController playerControllerSystem;
	SystemCollision collisionSystem;
	SystemRender renderSystem;

	@Override
	public void create() {

		entities = new Entity[3];
		//Player entity
		entities[0] = new Entity();
		entities[0].SetPlayerControllerComponent(new ComponentPlayerController(100, 100, 100, 100));
		//Collidable object 1
		entities[1] = new Entity();
		entities[1].SetCollisionComponent(new ComponentCollision(300, 300, 100, 100));
		//Collidable object 2
		entities[2] = new Entity();
		entities[2].SetCollisionComponent(new ComponentCollision(100, 100, 100, 100));


		player = entities[0].GetPlayerControllerComponent();

		playerControllerSystem = new SystemPlayerController();
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

		playerControllerSystem.Update(entities);
		collisionSystem.Update(entities);
		renderSystem.Update(entities);

	}
}
