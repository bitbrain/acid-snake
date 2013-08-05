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

package de.myreality.acidsnake.graphics;

import de.myreality.acid.CellManager;
import de.myreality.acid.gdx.GdxBufferedRenderer;
import de.myreality.acid.gdx.GdxCellRenderer;
import de.myreality.acidsnake.world.World;
import de.myreality.acidsnake.world.WorldEntity;
import de.myreality.acidsnake.world.WorldListener;

/**
 * Renderer which renders the world
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class WorldRenderer implements WorldListener {
	
	private CellManager manager;
	
	private GdxCellRenderer textureRenderer;
	
	public WorldRenderer(CellManager manager) {
		this.manager = manager;
		textureRenderer = new GdxCellRenderer((GdxBufferedRenderer) manager.getBufferedRenderer());
	}

	@Override
	public void onPut(int indexX, int indexY, WorldEntity target) {
		
		manager.setCellRenderer(textureRenderer);
		
		switch (target.getType()) {
			case SMALL_FOOD:
				
				break;
			case SNAKE:
				break;
			default:
				break;
		}
		
		manager.put(indexX, indexY);
	}

	@Override
	public void onRemove(int indexX, int indexY, WorldEntity target) {
		manager.clear(indexX, indexY);
	}

	@Override
	public void onBuild(World world) {
		
	}

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner classes
	// ===========================================================
}