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

package de.myreality.acidsnake.controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

import de.myreality.acidsnake.SnakeGame;
import de.myreality.acidsnake.core.Snake;
import de.myreality.acidsnake.screens.MainMenuScreen;
import de.myreality.acidsnake.util.Direction;
import de.myreality.acidsnake.world.World;

/**
 * Processor for ingame input handling
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class IngameProcessor implements InputProcessor {
	
	private SnakeGame game;
	
	private World world;
	
	public IngameProcessor(SnakeGame game, World world) {
		this.game = game;
		this.world = world;
		Gdx.input.setCatchBackKey(true);
	}

	@Override
	public boolean keyDown(int keycode) {
		
		Snake snake = world.getSnake();
		
		switch (keycode) {
		
			// ABORT GAME
			case Keys.BACK: case Keys.ESCAPE:
				game.setScreen(new MainMenuScreen(game));
				break;
				
			// MOVE SNAKE UP
			case Keys.W: case Keys.UP:
				snake.setDirection(Direction.UP);
				snake.move();
				break;
				
			// MOVE SNAKE DOWN
			case Keys.S: case Keys.DOWN:
				snake.setDirection(Direction.DOWN);
				snake.move();
				break;
				
			// MOVE SNAKE LEFT
			case Keys.A: case Keys.LEFT:
				snake.setDirection(Direction.LEFT);
				snake.move();
			break;
			
			// MOVE SNAKE LEFT
			case Keys.D: case Keys.RIGHT:
				snake.setDirection(Direction.RIGHT);
				snake.move();
			break;
		}
		
	    return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}


	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner classes
	// ===========================================================
}
