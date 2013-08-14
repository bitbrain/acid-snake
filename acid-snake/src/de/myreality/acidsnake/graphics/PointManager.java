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

import com.badlogic.gdx.Gdx;

import de.myreality.acid.CellManager;
import de.myreality.acidsnake.core.Snake;
import de.myreality.acidsnake.core.SnakeListener;
import de.myreality.acidsnake.ui.PopupManager;
import de.myreality.acidsnake.world.WorldEntity;

/**
 * Handles point displaying
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.3
 * @version 1.3
 */
public class PointManager implements SnakeListener {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private CellManager cellManager;
	
	private PopupManager popupManager;

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public PointManager(CellManager cellManager, PopupManager popupManager) {
		this.cellManager = cellManager;
		this.popupManager = popupManager;
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================

	@Override
	public void onEnterPosition(int indexX, int indexY, Snake snake) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCollide(int indexX, int indexY, Snake snake,
			WorldEntity target) {
		int x = (int) (cellManager.translateIndexX(indexX) + cellManager.getCellSize() / 2f);
		int y = (int) (Gdx.graphics.getHeight() - indexY * cellManager.getCellSize() - cellManager.getCellSize() / 2f);
		popupManager.popup(x, y, target.getType().getPoints() + "");
	}

	@Override
	public void onKill(Snake snake) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSpawn(Snake snake) {
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner classes
	// ===========================================================
}
