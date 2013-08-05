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

package de.myreality.acidsnake.world;

import de.myreality.acidsnake.core.Snake;
import de.myreality.acidsnake.player.Player;

/**
 * World which handles all game logic internally
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public interface World {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	/**
	 * Returns the current snake
	 * 
	 * @return current snake
	 */
	Snake getSnake();

	/**
	 * Resets the entire world. Reset the size of the snake to 3
	 */
	void reset();

	/**
	 * Returns the current player
	 * 
	 * @return current player
	 */
	Player getPlayer();

	/**
	 * 
	 * 
	 * @param indexX
	 * @param indexY
	 * @return
	 */
	boolean hasEntity(int indexX, int indexY);

	/**
	 * Returns the object at the given index position. Returns <code>null</code>
	 * if nothing is there.
	 * 
	 * @param indexX index X position
	 * @param indexY index Y position
	 * @return target object
	 */
	WorldEntity getEntity(int indexX, int indexY);

	/**
	 * Adds an object to the given position. If the object has already a valid position,
	 * it will be moved. If the target position consists already an object, nothing will happen
	 * and the method returns false.
	 * 
	 * @param indexX index X position 
	 * @param indexY index Y position
	 * @param object target object to transfer
	 * @return Returns false when the object has been put successfully
	 */
	boolean putEntity(int indexX, int indexY, WorldEntity entity);
	
	/**
	 * Removes the given entity from the world
	 * 
	 * @param entity
	 */
	void removeEntity(WorldEntity entity);
	
	/**
	 * Adds a new listener
	 * 
	 * @param listener world listener
	 */
	void addListener(WorldListener listener);
	
	/**
	 * Build the world (should be called in the create method)
	 */
	void build();

}
