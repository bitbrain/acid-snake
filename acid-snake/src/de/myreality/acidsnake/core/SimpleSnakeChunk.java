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

package de.myreality.acidsnake.core;

import de.myreality.acidsnake.world.SimpleWorldEntity;
import de.myreality.acidsnake.world.World;
import de.myreality.acidsnake.world.WorldEntityType;

/**
 * Implementation of {@link SnakeChunk}
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class SimpleSnakeChunk extends SimpleWorldEntity implements SnakeChunk {


	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private SnakeChunk next;

	// ===========================================================
	// Constructors
	// ===========================================================

	public SimpleSnakeChunk(int indexX, int indexY, World world) {
		super(indexX, indexY, WorldEntityType.SNAKE, world);
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================

	@Override
	public boolean isHead() {
		return getNext() == null;
	}

	@Override
	public SnakeChunk getNext() {
		return next;
	}

	@Override
	public void setNext(SnakeChunk next) {
		this.next = next;
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner classes
	// ===========================================================
}
