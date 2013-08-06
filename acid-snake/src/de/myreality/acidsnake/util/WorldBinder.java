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

package de.myreality.acidsnake.util;

import de.myreality.acidsnake.world.World;

/**
 * 
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 
 * @version 
 */
public class WorldBinder {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private World world;

	// ===========================================================
	// Constructors
	// ===========================================================

	public WorldBinder(World world) {
		this.world = world;
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
	
	public int bindIndexX(int indexX) {
		if (indexX >= world.getWidth()) {
			return 0;
		} else if (indexX < 0) {
			return world.getWidth() - 1;
		} else {
			return indexX;
		}
	}
	
	public int bindIndexY(int indexY) {
		if (indexY >= world.getHeight()) {
			return 0;
		} else if (indexY < 0) {
			return world.getHeight() - 1;
		} else {
			return indexY;
		}
	}

	// ===========================================================
	// Inner classes
	// ===========================================================
}
