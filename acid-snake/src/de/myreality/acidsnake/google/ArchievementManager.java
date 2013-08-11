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

package de.myreality.acidsnake.google;

import java.util.HashMap;
import java.util.Map;

import de.myreality.acidsnake.core.Snake;
import de.myreality.acidsnake.core.SnakeListener;
import de.myreality.acidsnake.util.Timer;
import de.myreality.acidsnake.world.WorldEntity;

/**
 * Manages all archievements
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class ArchievementManager implements SnakeListener {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private GoogleInterface google;
	
	private int lastLength;
	
	private BlockCounter counter30, counter40, counter50;

	// ===========================================================
	// Constructors
	// ===========================================================

	public ArchievementManager(GoogleInterface googleInterface) {
		google = googleInterface;
		counter30 = new BlockCounter(30, 60000);
		counter40 = new BlockCounter(40, 60000);
		counter50 = new BlockCounter(50, 60000);
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================

	@Override
	public void onEnterPosition(int indexX, int indexY, Snake snake) {
		
		if (lastLength != snake.getLength()) {		
			switch (snake.getLength()) {
				case 15:
					google.submitAchievement(Achievements.THE_LONG_SNAKE);
					break;
				case 30:
					google.submitAchievement(Achievements.THE_MONSTER_SNAKE);
					break;
				case 50:
					google.submitAchievement(Achievements.THE_GIANT_SNAKE);
					break;
			}
			
			lastLength = snake.getLength();
		}
		
		counter30.update();
		counter40.update();
		counter50.update();
		
		if (counter30.check()) {
			google.submitAchievement(Achievements.IN_A_ROW_30);
		}
		
		if (counter40.check()) {
			google.submitAchievement(Achievements.IN_A_ROW_40);
		}
		
		if (counter50.check()) {
			google.submitAchievement(Achievements.IN_A_ROW_50);
		}
	}

	@Override
	public void onCollide(int indexX, int indexY, Snake snake,
			WorldEntity target) {
		switch (target.getType()) {
		case ACID:
			break;
		case BOMB:
			break;
		case RARE_FOOD:
			break;
		case SMALL_FOOD:
			break;
		case SNAKE:
			break;
		case TELEPORTER:
			google.submitAchievement(Achievements.BEAM_ME_UP_SCOTTIE);
			break;
		default:
			break;
		}
		
		counter30.count();
		counter40.count();
		counter50.count();
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
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner classes
	// ===========================================================
	
	class BlockCounter {
		
		private final int BLOCKS;
		
		private final long TIME;
		
		private int pool, totalPool, index, maxIndex;
		
		private Map<Integer, Integer> poolMap;
		
		private Timer timer;
		
		public BlockCounter(final int BLOCKS, final long TIME) {
			this.BLOCKS = BLOCKS;
			this.TIME = TIME;
			pool = 0;
			totalPool = 0;
			poolMap = new HashMap<Integer, Integer>();
			timer = new Timer();
			timer.start();
			index = 0;
			maxIndex = 0;
		}
		
		public void count() {
			pool++;
		}
		
		public void update() {
			if (timer.getTicks() > 1000) {
				
				final int TIME_FACTOR = (int) (TIME / 1000f);
				
				timer.reset();
				
				if (poolMap.size() < TIME_FACTOR) {
					maxIndex = poolMap.size();
					poolMap.put(poolMap.size(), pool);
					totalPool += pool;
				} else {
					
					totalPool -= poolMap.get(index);
					poolMap.remove(index++);
					poolMap.put(++maxIndex, pool);
					totalPool += pool;
				}
				
				pool = 0;
			}
		}
		
		public boolean check() {
			return totalPool >= BLOCKS;
		}
	}
}
