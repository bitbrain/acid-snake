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

/**
 * Converts a movable for further calculations
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class IndexConverter {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private Indexable indexable;

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public IndexConverter(Indexable indexable) {
		this.indexable = indexable;
	}
	
	// ===========================================================
	// Getters and Setters
	// ===========================================================
	
	public Indexable getIndexable() {
		return indexable;
	}

	// ===========================================================
	// Methods from Superclass
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================
	
	public int getInvertedIndexX(Direction direction) {
		switch (direction) {
		case LEFT:
			return indexable.getIndexX() + 1;
		case RIGHT:
			return indexable.getIndexX() - 1;
		default:
			return indexable.getIndexX();
		}
	}
	
	public int getInvertedIndexY(Direction direction) {
		switch (direction) {
		case UP:
			return indexable.getIndexY() + 1;
		case DOWN:
			return indexable.getIndexY() - 1;
		default:
			return indexable.getIndexY();
		}
	}

	// ===========================================================
	// Inner classes
	// ===========================================================
}
