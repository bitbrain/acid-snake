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
 * Type of a world object
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public enum WorldEntityType implements SnakeListener {

	SNAKE {
		
		final int SNAKE_LENGTH = 3;

		@Override
		public void onEnterPosition(int indexX, int indexY, Snake snake) {
			
		}

		@Override
		public void onCollide(int indexX, int indexY, Snake snake,
				WorldEntity target) {
			if (target.getType().equals(this)) {
				snake.kill();
			}
		}

		@Override
		public void onKill(Snake snake) {
			
		}

		@Override
		public void onSpawn(Snake snake) {
			for (int i = 0; i < SNAKE_LENGTH; ++i) {
				snake.addChunk();
			}
		}
	},
	
	SMALL_FOOD {

		@Override
		public void onEnterPosition(int indexX, int indexY, Snake snake) {
			
		}

		@Override
		public void onCollide(int indexX, int indexY, Snake snake,
				WorldEntity target) {
			if (target.getType().equals(this)) {
				snake.addChunk();
			}
		}

		@Override
		public void onKill(Snake snake) {
			
		}

		@Override
		public void onSpawn(Snake snake) {
			spawnAtRandomPosition(this, snake.getWorld());
		}
		
	};
	
	private static WorldEntityFactory entityFactory = null; // TODO
	
	private static void spawnAtRandomPosition(WorldEntityType type, World world) {
		
		if (entityFactory == null) {
			entityFactory = new SimpleWorldEntityFactory(world);
		}
		
		
		int randomX = 0, randomY = 0;
		boolean validPosition = false;
		
		while (!validPosition) {
			
			randomX = (int) (Math.random() * world.getWidth());
			randomY = (int) (Math.random() * world.getHeight());
			
			validPosition = !world.hasEntity(randomX, randomY);
		}
		
		entityFactory.create(randomX, randomY, type);
	}
}
