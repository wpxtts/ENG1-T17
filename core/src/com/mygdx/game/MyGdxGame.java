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
	SpriteBatch batch;
	private ShapeRenderer shapeRenderer;
	private OrthographicCamera camera;
	Entity[] entities;
	ComponentPlayerController player;

	SystemPlayerController playerControllerSystem;
	SystemCollision collisionSystem;
	SystemRender renderSystem;

	@Override
	public void create() {
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		// Create OrthographicCamera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		entities = new Entity[2];
		entities[0] = new Entity();
		entities[0].SetPlayerControllerComponent(new ComponentPlayerController(100, 100, 100, 100));
		entities[1] = new Entity();
		entities[1].SetCollisionComponent(new ComponentCollision(300, 300, 100, 100));

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



		// Update camera to follow the asset
		camera.position.set(player.x + player.width / 2, player.y + player.height / 2, 0);
		camera.update();

		// Set the batch projection matrix to the camera's combined matrix
		batch.setProjectionMatrix(camera.combined);
		shapeRenderer.setProjectionMatrix(camera.combined);

		// Start rendering shapes


	}

	@Override
	public void dispose() {
		batch.dispose();
		shapeRenderer.dispose();
	}

	void UpdateFrame() {

		playerControllerSystem.Update(entities);
		collisionSystem.Update(entities);
		renderSystem.Update(entities);

	}
}
