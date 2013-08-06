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
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;

import de.myreality.acid.Acid;
import de.myreality.acid.gdx.GdxBufferedRenderer;
import de.myreality.acidsnake.SnakeGame;
import de.myreality.acidsnake.controls.IngameProcessor;
import de.myreality.acidsnake.graphics.WorldRenderer;
import de.myreality.acidsnake.util.Direction;
import de.myreality.acidsnake.world.SimpleWorld;
import de.myreality.acidsnake.world.World;

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
	
	private World world;
	
	private WorldRenderer worldRenderer;
	
	private GdxBufferedRenderer bufferedRenderer;

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
	

	boolean pressed;

	@Override
	public void render(float delta) {
		float color = 0.0f;
		Gdx.gl.glClearColor(color, color, color, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		acid.render();
	}

	@Override
	public void resize(int width, int height) {

	}
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(new IngameProcessor(game));
		
		final int VERTICAL_INDEX = 12;
		final int CELL_SIZE = Gdx.graphics.getHeight() / VERTICAL_INDEX;
		final int HORIZONTAL_INDEX = (int) (Gdx.graphics.getWidth() / CELL_SIZE);
		
		bufferedRenderer = new GdxBufferedRenderer();
        acid = new Acid(HORIZONTAL_INDEX, VERTICAL_INDEX, CELL_SIZE, bufferedRenderer);	
        acid.setPadding(4);
        acid.setPosition(Gdx.graphics.getWidth() / 2f - acid.getWidth() / 2f, 
							   Gdx.graphics.getHeight() / 2f - acid.getHeight() / 2f);
        
        world = new SimpleWorld(HORIZONTAL_INDEX, VERTICAL_INDEX);
        
        worldRenderer = new WorldRenderer(acid);
        world.addListener(worldRenderer);

        world.build();
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
