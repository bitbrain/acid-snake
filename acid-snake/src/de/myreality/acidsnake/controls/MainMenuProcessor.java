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
import com.badlogic.gdx.scenes.scene2d.Stage;

import de.myreality.acidsnake.SnakeGame;
import de.myreality.acidsnake.screens.IngameScreen;

/**
 * Processor for the main menu
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class MainMenuProcessor extends Stage {
	
	private SnakeGame game;
	
	
	
	public MainMenuProcessor(float width, float height, SnakeGame game) {
		super(width, height, false);
		this.game = game;
		Gdx.input.setCatchBackKey(true);
	}
	
	@Override
	public boolean keyDown(int keycode) {
		super.keyDown(keycode);
		if(keycode == Keys.BACK || keycode == Keys.ESCAPE){
			Gdx.app.exit();
			return true;
	    }
	    return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (!super.touchDown(screenX, screenY, pointer, button)) {
			game.setScreen(new IngameScreen(game));
		}
		
		return true;
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
