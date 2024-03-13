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

	SystemPlayerController playerControllerSystem;
	SystemCollision collisionSystem;
	SystemRender renderSystem;

	@Override
	public void create() {

		entities = new Entity[3];
		entities[0] = new Entity();
		entities[0].SetPositionComponent(new ComponentPosition(100, 100, 100, 100));
		entities[0].SetPlayerControllerComponent(new ComponentPlayerController());
		entities[0].SetSpriteComponent(new ComponentSprite());

		entities[1] = new Entity();
		entities[1].SetPositionComponent(new ComponentPosition(300, 300, 100, 100));
		entities[1].SetCollisionComponent(new ComponentCollision(false));
		entities[1].SetSpriteComponent(new ComponentSprite());

		entities[2] = new Entity();
		entities[2].SetPositionComponent(new ComponentPosition(50, 500, 100, 100));
		entities[2].SetCollisionComponent(new ComponentCollision(true));
		entities[2].SetSpriteComponent(new ComponentSprite());

		playerControllerSystem = new SystemPlayerController();
		collisionSystem = new SystemCollision();
		renderSystem = new SystemRender();
	}

	@Override
	public void render() {

		// Turn the screen black.
		ScreenUtils.clear(0, 0, 0, 1);

		// updates all the systems this frame.
		playerControllerSystem.Update(entities);
		collisionSystem.Update(entities);
		renderSystem.Update(entities);

	}

}
