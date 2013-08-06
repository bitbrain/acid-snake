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
 * Abstract implementation of {@link Indexable}
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class AbstractIndexable implements Indexable {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private int indexX, indexY;
	
	private int lastIndexX, lastIndexY;

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public AbstractIndexable(int indexX, int indexY) {
		this.indexX = indexX;
		this.indexY = indexY;
		this.lastIndexX = indexX;
		this.lastIndexY = indexY;
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================

	@Override
	public int getIndexX() {
		return indexX;
	}

	@Override
	public int getIndexY() {
		return indexY;
	}

	@Override
	public void setIndexX(int indexX) {
		setIndex(indexX, indexY);
	}

	@Override
	public void setIndexY(int indexY) {
		setIndex(indexX, indexY);
	}

	@Override
	public int getLastIndexX() {
		return lastIndexX;
	}

	@Override
	public int getLastIndexY() {
		return lastIndexY;
	}

	@Override
	public void setIndex(int indexX, int indexY) {
		
		if (this.indexY != indexY) {
			this.lastIndexY = this.indexY;
			this.indexY = indexY;			
		}
		
		if (this.indexX != indexX) {
			this.lastIndexX = this.indexX;
			this.indexX = indexX;
		}
	}

	@Override
	public void setLastIndexX(int indexX) {
		this.lastIndexX = indexX;
	}

	@Override
	public void setLastIndexY(int indexY) {
		this.lastIndexY = indexY;
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner classes
	// ===========================================================
}
