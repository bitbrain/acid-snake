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

import java.util.HashSet;
import java.util.Set;

import de.myreality.acidsnake.core.Player;
import de.myreality.acidsnake.core.SimplePlayer;
import de.myreality.acidsnake.core.SimpleSnake;
import de.myreality.acidsnake.core.Snake;

/**
 * World class which handles the entire game
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class SimpleWorld implements World {
	
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private Snake snake;
	
	private Player player;
	
	private Set<WorldListener> listeners;
	
	private int width, height;
	
	private WorldEntity[][] area;
	
	private Set<WorldEntity> entities;

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public SimpleWorld(int width, int height) {
		this.width = width;
		this.height = height;
		listeners = new HashSet<WorldListener>();
		entities = new HashSet<WorldEntity>();
		area = new WorldEntity[width][height];
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================
	
	@Override
	public Snake getSnake() {
		return snake;
	}

	@Override
	public void reset() {
		
		Set<WorldEntity> copy = new HashSet<WorldEntity>(entities);
		
		for (WorldEntity entity : copy) {
			removeEntity(entity);
		}
		
		build();
	}

	@Override
	public Player getPlayer() {
		return player;
	}

	@Override
	public boolean hasEntity(int indexX, int indexY) {
		return getEntity(indexX, indexY) != null;
	}

	@Override
	public WorldEntity getEntity(int indexX, int indexY) {
		return area[indexX][indexY];
	}

	@Override
	public boolean putEntity(int indexX, int indexY, WorldEntity entity) {
		
		WorldEntity old = getEntity(indexX, indexY);
		boolean oldExists = old != null;
		boolean isTheSame = oldExists && old.equals(entity);
		
		if (oldExists && !isTheSame) {
			removeEntity(old);
		} 
		
		if (!oldExists || !isTheSame) {
			for (WorldListener listener : listeners) {
				listener.onPut(indexX, indexY, entity, this);
			}
			
			entities.add(entity);
			area[indexX][indexY] = entity;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void removeEntity(WorldEntity entity) {
		if (entity != null && entities.contains(entity)) {
			
			int indexX = entity.getIndexX(), indexY = entity.getIndexY();
			
			for (WorldListener listener : listeners) {
				listener.onRemove(indexX, indexY, entity, this);
			}
			
			entities.remove(entity);
			area[indexX][indexY] = null;
		}
	}

	@Override
	public void addListener(WorldListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	@Override
	public void build() {
		player = new SimplePlayer();
		snake = new SimpleSnake(5, 5, this);		
		snake.build();
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner classes
	// ===========================================================
}
