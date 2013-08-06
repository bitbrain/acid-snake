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

import de.myreality.acidsnake.util.AbstractIndexable;
import de.myreality.acidsnake.util.WorldBinder;

/**
 * Implementation of {@link WorldEntity}
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class SimpleWorldEntity extends AbstractIndexable implements WorldEntity {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private WorldEntityType type;
	
	private World world;
	
	private WorldBinder binder;
	
	// ===========================================================
	// Constructors
	// ===========================================================
	
	public SimpleWorldEntity(int indexX, int indexY, WorldEntityType type, World world) {
		super(indexX, indexY);
		this.type = type;
		this.world = world;
		binder = new WorldBinder(world);
	}
	
	public SimpleWorldEntity(WorldEntityType type, World world) {
		this(0, 0, type, world);
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================

	@Override
	public WorldEntityType getType() {
		return type;
	}

	@Override
	public World getWorld() {
		return world;
	}

	@Override
	public void setIndex(int indexX, int indexY) {
		world.putEntity(indexX, indexY, this);
		indexX = binder.bindIndexX(indexX);
		indexY = binder.bindIndexY(indexY);
		super.setIndex(indexX, indexY);
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner classes
	// ===========================================================
}
