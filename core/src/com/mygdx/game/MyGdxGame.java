package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * The main class which manages the loop of the game.
 */
public class MyGdxGame extends Game {

	public SpriteBatch batch;
	public BitmapFont font;
	public ShapeRenderer shapeRenderer;
	private Stage stage;

	/**
	 * Initialises sprite batch, font and sets intial screen to MenuScreen.
	 */
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(); // use libGDX's default Arial font
		this.setScreen(new MenuScreen(this));
		shapeRenderer = new ShapeRenderer();
	}

	/**
	 * Renders the screen
	 */
	public void render() {
		super.render(); // important!
	}

	/**
	 * Clear up screen from leftover sprites and text
	 */
	public void dispose() {
		batch.dispose();
		font.dispose();
	}

	/**
	 * Change screen to CreditScreen
	 */
	public void toCreditScreen(){
		this.setScreen(new CreditScreen(this));
	}

	/**
	 * Change screen to GameScreen
	 */
	public void toGameScreen(){
		this.setScreen(new GameScreen(this));
	}

	/**
	 * Change screen to MenuScreen
	 */
	public void toMainMenu(){
		this.setScreen(new MenuScreen(this));
	}

	/**
	 * Change to TutorialScreen
	 */
	public void toTutorialScreen(){
		this.setScreen(new TutorialScreen(this));
	}

	public void toScoreScreen(){
		this.setScreen(new ScoreScreen(this));
	}

}
