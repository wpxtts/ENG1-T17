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
	public SpriteBatch hudBatch;
	public BitmapFont font;
	public ShapeRenderer shapeRenderer;

	/**
	 * Initialises sprite batch, font and sets intial screen to MenuScreen.
	 */
	public void create() {
		batch = new SpriteBatch();
		hudBatch = new SpriteBatch();
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
	@Override
	public void dispose() {
		System.out.println("MyGdxGame.java dispose called");
		batch.dispose();
		font.dispose();
		shapeRenderer.dispose();
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
	public void toMainScreen(){
		this.setScreen(new MenuScreen(this));
	}

	/**
	 * Change to TutorialScreen
	 */
	public void toTutorialScreen(){
		this.setScreen(new TutorialScreen(this));
	}

	/**
	 * Change to score screen
	 * @param study number of times the player studied in the week
	 * @param fun number of times the player had fun in the week
	 * @param eat number of times the player ate in the week
	 */
	public void toScoreScreen(int study, int fun, int eat){

		this.setScreen(new ScoreScreen(this,study, fun, eat));
	}

}
