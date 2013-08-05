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
import java.util.Set;

import de.myreality.acidsnake.util.Direction;
import de.myreality.acidsnake.world.World;

/**
 * Implementation of {@link Snake}
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class SimpleSnake implements Snake {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private Direction direction;
	
	private float speed;
	
	private List<SnakeChunk> chunks;
	
	private World world;
	
	private boolean killed;
	
	private Set<SnakeListener> listeners;

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================

	@Override
	public void setDirection(Direction direction) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSpeed(float speed) {
		// TODO Auto-generated method stub

	}

	@Override
	public float getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SnakeChunk> getChunks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addChunk() {
		// TODO Auto-generated method stub

	}

	@Override
	public SnakeChunk getHead() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SnakeChunk getTail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public World getWorld() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addListener(SnakeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void spawn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void kill() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isKilled() {
		// TODO Auto-generated method stub
		return false;
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner classes
	// ===========================================================
}
