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

package de.myreality.acidsnake.google;

import de.myreality.acidsnake.core.Snake;
import de.myreality.acidsnake.core.SnakeListener;
import de.myreality.acidsnake.world.WorldEntity;

/**
 * Manages all archievements
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class ArchievementManager implements SnakeListener {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private GoogleInterface google;
	
	private int lastLength;

	// ===========================================================
	// Constructors
	// ===========================================================

	public ArchievementManager(GoogleInterface googleInterface) {
		google = googleInterface;
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================

	@Override
	public void onEnterPosition(int indexX, int indexY, Snake snake) {
		
		if (lastLength != snake.getLength()) {		
			switch (snake.getLength()) {
				case 15:
					google.submitArchivement(Archievements.THE_LONG_SNAKE);
					break;
				case 30:
					google.submitArchivement(Archievements.THE_MONSTER_SNAKE);
					break;
				case 50:
					google.submitArchivement(Archievements.THE_GIANT_SNAKE);
					break;
			}
			
			lastLength = snake.getLength();
		}
	}

	@Override
	public void onCollide(int indexX, int indexY, Snake snake,
			WorldEntity target) {
		switch (target.getType()) {
		case ACID:
			break;
		case BOMB:
			break;
		case RARE_FOOD:
			break;
		case SMALL_FOOD:
			break;
		case SNAKE:
			break;
		case TELEPORTER:
			google.submitArchivement(Archievements.BEAM_ME_UP_SCOTTIE);
			break;
		default:
			break;
		
		}
	}

	@Override
	public void onKill(Snake snake) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSpawn(Snake snake) {
		// TODO Auto-generated method stub

	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner classes
	// ===========================================================
}
