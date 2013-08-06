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

import java.util.List;

import de.myreality.acidsnake.util.Buildable;
import de.myreality.acidsnake.util.Indexable;
import de.myreality.acidsnake.util.Moveable;
import de.myreality.acidsnake.world.World;

/**
 * Snake which can be moved through the world
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public interface Snake extends Moveable, Indexable, Buildable {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================
	
	/**
	 * Returns all current chunks
	 * 
	 * @return
	 */
	List<SnakeChunk> getChunks();
	
	/**
	 * Adds a new chunk to the snake
	 */
	void addChunk();
	
	/**
	 * Returns the head of the snake
	 * 
	 * @return head snake chunk
	 */
	SnakeChunk getHead();
	
	/**
	 * Returns the tail of the snake
	 * 
	 * @return tail snake chunk
	 */
	SnakeChunk getTail();
	
	/**
	 * Returns the world to which the snake belongs to
	 * 
	 * @return current world
	 */
	World getWorld();
	
	/**
	 * Adds a new listener to the snake
	 * 
	 * @param listener listener to add
	 */
	void addListener(SnakeListener listener);
	
	
	/**
	 * Spawns the snake at a random position
	 */
	void spawn();
	
	/**
	 * Kills the snake
	 */
	void kill();
	
	/**
	 * Returns true when killed
	 * 
	 * @return killed when killed
	 */
	boolean isKilled();
}
