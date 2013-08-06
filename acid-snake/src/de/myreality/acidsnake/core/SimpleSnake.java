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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.myreality.acidsnake.util.Direction;
import de.myreality.acidsnake.world.SimpleWorldEntityFactory;
import de.myreality.acidsnake.world.World;
import de.myreality.acidsnake.world.WorldEntityFactory;
import de.myreality.acidsnake.world.WorldEntityType;

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
	
	private SnakeChunk head, tail;
	
	private World world;
	
	private boolean killed;
	
	private Set<SnakeListener> listeners;
	
	private WorldEntityFactory factory;

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public SimpleSnake(World world) {
		this.world = world;
		listeners = new HashSet<SnakeListener>();
		chunks = new ArrayList<SnakeChunk>();
		factory = new SimpleWorldEntityFactory(world);
		addChunk();
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================

	@Override
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public void setSpeed(float speed) {
		this.speed = speed;
	}

	@Override
	public float getSpeed() {
		return speed;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SnakeChunk> getChunks() {
		return chunks;
	}

	@Override
	public void addChunk() {
		SnakeChunk chunk = (SnakeChunk) factory.create(WorldEntityType.SNAKE);
		
		if (!chunks.isEmpty()) {
			head = chunk;
		}
		
		chunks.add(chunk);
		tail = chunk;
	}

	@Override
	public SnakeChunk getHead() {
		return head;
	}

	@Override
	public SnakeChunk getTail() {
		return tail;
	}

	@Override
	public World getWorld() {
		return world;
	}

	@Override
	public void addListener(SnakeListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	@Override
	public void spawn() {
		for (SnakeListener listener : listeners) {
			listener.onSpawn(this);
		}
	}

	@Override
	public void kill() {
		for (SnakeListener listener : listeners) {
			listener.onKill(this);
		}
	}

	@Override
	public boolean isKilled() {
		return killed;
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner classes
	// ===========================================================
}
