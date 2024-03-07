package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.Input.Keys;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private ShapeRenderer shapeRenderer;
	private OrthographicCamera camera;
	private float x = 100;
	private float y = 100;
	private float width = 100;
	private float height = 100;

	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		shapeRenderer = new ShapeRenderer();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
	}

	@Override
	public void render() {
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.begin(ShapeType.Filled);

		// Set the color to red
		shapeRenderer.setColor(Color.RED);

		// Draw a small red block at position (x, y) with width and height of 10 pixels
		shapeRenderer.rect(x, y, width, height);

		// End rendering shapes
		shapeRenderer.end();
		camera.update();
		handleInput();
	}

	private void handleInput() {
		// Move the block with arrow keys
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			x -= 200 * Gdx.graphics.getDeltaTime();
		}
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			x += 200 * Gdx.graphics.getDeltaTime();
		}
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			y += 200 * Gdx.graphics.getDeltaTime();
		}
		if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			y -= 200 * Gdx.graphics.getDeltaTime();
		}
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
		shapeRenderer.dispose();
	}
}
