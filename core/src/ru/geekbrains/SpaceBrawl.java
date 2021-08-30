package ru.geekbrains;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class SpaceBrawl extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture menuBackground;
	private int scaledHeight;
	private int scaledWidth;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		menuBackground = new Texture("menu_background.jpg");

		float imageRatioH = (float) Gdx.graphics.getHeight() / menuBackground.getHeight();
		float imageRatioW = (float) Gdx.graphics.getWidth() / menuBackground.getWidth();
		scaledHeight = (int) (menuBackground.getHeight() * imageRatioH);
		scaledWidth = (int) (menuBackground.getWidth() * imageRatioW);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(menuBackground, 0, 0, scaledWidth, scaledHeight);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		menuBackground.dispose();
	}
}
