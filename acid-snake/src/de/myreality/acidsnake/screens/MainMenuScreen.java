/* AcidSnake - Snake game using Acid
 * Copyright (C) 2013  Miguel Gonzalez
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA
 */

package de.myreality.acidsnake.screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import de.myreality.acid.BufferedRenderer;
import de.myreality.acid.gdx.GdxBufferedRenderer;
import de.myreality.acidsnake.Resources;
import de.myreality.acidsnake.SnakeGame;
import de.myreality.acidsnake.graphics.RandomAcid;
import de.myreality.acidsnake.tweens.LabelTween;
import de.myreality.acidsnake.tweens.SpriteTween;
import de.myreality.chronos.resources.ResourceManager;

/**
 * Displays a fancy main menu
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class MainMenuScreen implements Screen {
	
	private SnakeGame game;
	
	private RandomAcid acdBackground;
	
	private Image imgLogo;
	
	private SpriteBatch batch;
	
	private ResourceManager resourceManager = ResourceManager.getInstance();
	
	private Label lblStart;
	
	private Stage stage;

	private TweenManager tweenManager;
	
	public MainMenuScreen(SnakeGame game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		float color = 0.0f;
		Gdx.gl.glClearColor(color, color, color, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		tweenManager.update(delta);
		stage.act(delta);

		acdBackground.render();
		batch.begin();
			stage.draw();
		batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		if (stage == null) {
			stage = new Stage(width, height, false);
		
			LabelStyle lblStyle = new LabelStyle();
			
			lblStyle.font = resourceManager.getResource(Resources.BITMAP_FONT_REGULAR, BitmapFont.class);
			lblStyle.fontColor = resourceManager.getResource(Resources.COLOR_GREEN, Color.class);
			
			lblStart = new Label(resourceManager.getResource(Resources.STRING_START_GAME, String.class),
					             lblStyle);
			
			lblStart.setPosition(Gdx.graphics.getWidth() / 2f - lblStart.getWidth() / 2f,
								 Gdx.graphics.getHeight() / 2f - lblStart.getHeight() / 2f - Gdx.graphics.getHeight() / 8f);
			
			stage.addActor(lblStart);
		
		
			imgLogo = new Image(resourceManager.getResource(Resources.TEXTURE_GAME_LOGO, Texture.class));
		
		
		
			imgLogo.setPosition(Gdx.graphics.getWidth() / 2f - imgLogo.getWidth() / 2f,
								 (Gdx.graphics.getHeight() / 2f - imgLogo.getHeight() / 2f) + Gdx.graphics.getHeight() / 4f);
		
			stage.addActor(imgLogo);
		
			tweenManager = new TweenManager();
			Tween.registerAccessor(Label.class, new LabelTween());
			Tween.to(lblStart, LabelTween.ALPHA, 100)
				 	.target(0f)
					.ease(TweenEquations.easeInOutQuad)
					.repeatYoyo(1, 1.5f)
					.setCallbackTriggers(TweenCallback.COMPLETE)
					.start(tweenManager);
		} else {
			
			stage.setViewport(width, height, false);
			lblStart.setPosition(Gdx.graphics.getWidth() / 2f - lblStart.getWidth() / 2f,
					 Gdx.graphics.getHeight() / 2f - lblStart.getHeight() / 2f - Gdx.graphics.getHeight() / 8f);
			imgLogo.setPosition(Gdx.graphics.getWidth() / 2f - imgLogo.getWidth() / 2f,
					 (Gdx.graphics.getHeight() / 2f - imgLogo.getHeight() / 2f) + Gdx.graphics.getHeight() / 4f);
			
		}
	}

	@Override
	public void show() {
		
		batch = new SpriteBatch();
		BufferedRenderer renderer = new GdxBufferedRenderer();
		acdBackground = new RandomAcid(renderer);
		acdBackground.backgroundColor(0.0f, 0.0f, 0.0f);		
		
		acdBackground.setIndexY(12);

		acdBackground.setSize(Gdx.graphics.getHeight() / 12);		

		acdBackground.setIndexX((int) (Gdx.graphics.getWidth() / acdBackground.getCellSize()));
		
		acdBackground.setPosition(Gdx.graphics.getWidth() / 2f - acdBackground.getWidth() / 2f, 
							   Gdx.graphics.getHeight() / 2f - acdBackground.getHeight() / 2f);		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	
}
