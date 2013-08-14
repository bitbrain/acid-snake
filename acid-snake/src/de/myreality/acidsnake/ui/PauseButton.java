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

package de.myreality.acidsnake.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

import de.myreality.acidsnake.util.Pauseable;

/**
 * Button which pauses a pausable and vise versa
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.3
 * @version 1.3
 */
public class PauseButton extends Button {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private Pauseable pauseable;

	// ===========================================================
	// Constructors
	// ===========================================================

	public PauseButton(Pauseable pause, ButtonStyle style) {
		super(style);
		this.pauseable = pause;
		setColor(1f, 1f, 1f, 0.4f);
		final Button pauseButton = this;
		
		addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				pauseable.setPaused(!pauseable.isPaused());
				
				if (pauseable.isPaused()) {
					pauseButton.setColor(1f, 1f, 1f, 1f);
				} else {
					pauseButton.setColor(1f, 1f, 1f, 0.4f);
				}
				return true;
			}
		});
	}

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
