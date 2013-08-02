/* Acid - Provides a Java cell API to display fancy cell boxes.
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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;

import de.myreality.acid.Acid;
import de.myreality.acid.gdx.GdxBufferedRenderer;
import de.myreality.acidsnake.SnakeGame;
import de.myreality.acidsnake.controls.MainMenuProcessor;

/**
 * Ingame screen which handles the basic game
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class IngameScreen implements Screen {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private SnakeGame game;
	
	private Acid acid;

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public IngameScreen(SnakeGame game) {
		this.game = game;
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================
	


	@Override
	public void render(float delta) {
		float color = 0.0f;
		Gdx.gl.glClearColor(color, color, color, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		acid.render();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(new MainMenuProcessor(game));
        Gdx.input.setCatchBackKey(true);
        
        acid = new Acid(new GdxBufferedRenderer());
        acid.setIndexY(12);
        acid.setSize(Gdx.graphics.getHeight() / 12);
        acid.setIndexX((int) (Gdx.graphics.getWidth() / acid.getCellSize()));		
        acid.setPosition(Gdx.graphics.getWidth() / 2f - acid.getWidth() / 2f, 
							   Gdx.graphics.getHeight() / 2f - acid.getHeight() / 2f);
        acid.color(1f, 0, 0);
        acid.put(0, 1);
        
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

	
	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner classes
	// ===========================================================
}
