package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MyGdxGame extends Game {

	public SpriteBatch batch;
	public BitmapFont font;
	private Stage stage;

	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(); // use libGDX's default Arial font
		this.setScreen(new MenuScreen(this));
	}

	public void render() {
		super.render(); // important!
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}

	public void toCreditScreen(){
		this.setScreen(new CreditScreen(this));
	}
	public void toGameScreen(){
		this.setScreen(new GameScreen(this));
	}

	public void toMainMenu(){
		this.setScreen(new MenuScreen(this));
	}

	public void toTutorialScreen(){
		this.setScreen(new TutorialScreen(this));
	}

}