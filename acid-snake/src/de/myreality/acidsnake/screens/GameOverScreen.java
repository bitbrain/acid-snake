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
import com.badlogic.gdx.scenes.scene2d.Stage;

import de.myreality.acid.BufferedRenderer;
import de.myreality.acid.gdx.GdxBufferedRenderer;
import de.myreality.acidsnake.SnakeGame;
import de.myreality.acidsnake.controls.GameOverProcessor;
import de.myreality.acidsnake.core.Player;
import de.myreality.acidsnake.graphics.RandomAcid;
import de.myreality.acidsnake.ui.PlayerTable;

/**
 * Shows the game result
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class GameOverScreen implements Screen {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private Player player;
	
	private SnakeGame game;

	private RandomAcid acdBackground;
	
	private Stage stage;

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public GameOverScreen(SnakeGame game, Player player) {
		this.player = player;
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
		
		stage.act(delta);
		
		acdBackground.render();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		if (stage == null) {
			stage = new Stage(width, height, false);
			PlayerTable results = new PlayerTable(player);
			stage.addActor(results);
			results.setX(Gdx.graphics.getWidth() / 2f - results.getWidth() / 2f);
			results.setY(Gdx.graphics.getHeight() / 2f - results.getHeight() / 2f);
		} else {
			stage.setViewport(width, height, false);
		}
	}

	@Override
	public void show() {
		
		BufferedRenderer renderer = new GdxBufferedRenderer();			
		
		final int VERTICAL_INDEX = 8;
		final int CELL_SIZE = Gdx.graphics.getHeight() / VERTICAL_INDEX;
		final int HORIZONTAL_INDEX = (int) (Gdx.graphics.getWidth() / CELL_SIZE);
		
		acdBackground = new RandomAcid(HORIZONTAL_INDEX, VERTICAL_INDEX, CELL_SIZE, renderer);	

		acdBackground.backgroundColor(0.0f, 0.0f, 0.0f);	
		acdBackground.setPadding(5);
		acdBackground.setPosition(Gdx.graphics.getWidth() / 2f - acdBackground.getWidth() / 2f, 
							   Gdx.graphics.getHeight() / 2f - acdBackground.getHeight() / 2f);
		
		Gdx.input.setInputProcessor(new GameOverProcessor(game));
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
		stage.dispose();
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner classes
	// ===========================================================
}
