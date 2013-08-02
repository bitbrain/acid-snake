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
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.myreality.acidsnake.Resources;
import de.myreality.acidsnake.SnakeGame;
import de.myreality.acidsnake.tweens.SpriteTween;

/**
 * Screen which displays the intro of the game. The intro can be skipped by
 * touching (clicking) on it.
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 0.0.1
 * @version 0.0.1
 */
public class IntroScreen implements Screen {
	
	private final static float DURATION = 1f;
	
	// Reference of the current game
	private SnakeGame game;
	
	// Sprite batch to draw stuff
	private SpriteBatch batch;
	
	// Contains the intro logo
	private Sprite spriteIntro;
	
	// Manager to handle the fade animation
	private TweenManager tweenManager;
	
	public IntroScreen(SnakeGame game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		float color = 0.0f;
		Gdx.gl.glClearColor(color, color, color, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		if (Gdx.input.isTouched()) {
			game.setScreen(new MainMenuScreen(game));
		}
		
		tweenManager.update(delta);
		
		batch.begin();
		spriteIntro.draw(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		
		batch = new SpriteBatch();
		Texture texLogo = Resources.TEXTURE_ACID_LOGO;
		spriteIntro = new Sprite(texLogo);
		
		// Center the logo into center
		float x = Gdx.graphics.getWidth() / 2f - spriteIntro.getWidth() / 2f;
		float y  = Gdx.graphics.getHeight() / 2f - spriteIntro.getHeight() / 2f;
		spriteIntro.setPosition(x, y);
		spriteIntro.setColor(1f, 1f, 1f, 0f); 
		
		TweenCallback animationEnded = new TweenCallback() {

			@Override
			public void onEvent(int tweenId, BaseTween<?> tween) {
				game.setScreen(new MainMenuScreen(game));
			}
			
		};

		tweenManager = new TweenManager();
		Tween.registerAccessor(Sprite.class, new SpriteTween());
		Tween.to(spriteIntro, SpriteTween.ALPHA, DURATION)
			 	.target(1f)
				.ease(TweenEquations.easeInOutQuad)
				.repeatYoyo(1, 1.5f)
				.setCallback(animationEnded)
				.setCallbackTriggers(TweenCallback.COMPLETE)
				.start(tweenManager);
	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}
}
