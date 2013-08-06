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
import de.myreality.acidsnake.core.SnakeListener;

/**
 * Debugger to debug a single world
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class WorldDebugger implements SnakeListener {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private World world;

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public WorldDebugger(World world) {
		this.world = world;
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================
		
	public void debug() {
		for (int y = 0; y < world.getHeight(); ++y) {
			for (int x = 0; x < world.getWidth(); ++x) {
				if (world.hasEntity(x, y)) {
					System.out.print('x');
				} else {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
	}

	@Override
	public void onEnterPosition(int indexX, int indexY, Snake snake) {
		debug();
	}

	@Override
	public void onCollide(int indexX, int indexY, Snake snake,
			WorldEntity target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKill(Snake snake) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSpawn(Snake snake) {
		// TODO Auto-generated method stub
		
	}

	// ===========================================================
	// Inner classes
	// ===========================================================
}
