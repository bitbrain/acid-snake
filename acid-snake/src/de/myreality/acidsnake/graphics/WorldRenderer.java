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

import com.badlogic.gdx.graphics.Color;

import de.myreality.acid.CellManager;
import de.myreality.acid.CellRenderer;
import de.myreality.acidsnake.Resources;
import de.myreality.acidsnake.world.World;
import de.myreality.acidsnake.world.WorldEntity;
import de.myreality.acidsnake.world.WorldEntityType;
import de.myreality.acidsnake.world.WorldHandler;

/**
 * Renderer which renders the world
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class WorldRenderer extends WorldHandler {
	
	private CellManager manager;
	
	public WorldRenderer(CellManager manager) {
		this.manager = manager;
	}

	@Override
	public void onPut(int indexX, int indexY, WorldEntity target, World world) {
		
		Color color = Resources.COLOR_GREEN;
		CellRenderer cellRenderer = target.getType().getCellRenderer();
		
		if (cellRenderer != null) {
			manager.setCellRenderer(cellRenderer);
		}
		
		manager.color(color.r, color.g, color.b);
		manager.put(indexX, indexY);
	}

	@Override
	public void onRemove(int indexX, int indexY, WorldEntity target, World world) {
		if (target.renderRequested() || !(target.getType().equals(WorldEntityType.SNAKE) && !world.getSnake().getTail().equals(target))) {
			manager.clear(indexX, indexY);
		}
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