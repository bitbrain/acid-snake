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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import de.myreality.acidsnake.core.Snake;
import de.myreality.acidsnake.core.SnakeListener;
import de.myreality.acidsnake.util.Timer;
import de.myreality.acidsnake.world.World;
import de.myreality.acidsnake.world.WorldEntity;
import de.myreality.acidsnake.world.WorldEntityType;
import de.myreality.acidsnake.world.WorldHandler;

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
	
	private Set<WorldEntityType> collected;
	
	private ComboDetector comboDetector;

	// ===========================================================
	// Constructors
	// ===========================================================

	public ArchievementManager(World world, GoogleInterface googleInterface) {
		google = googleInterface;
		collected = new HashSet<WorldEntityType>();
		counter30 = new BlockCounter(30, 60000);
		counter40 = new BlockCounter(40, 60000);
		counter50 = new BlockCounter(50, 60000);
		world.addListener(counter30);
		world.addListener(counter40);
		world.addListener(counter50);
		comboDetector = new ComboDetector();
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
		
		comboDetector.update(target.getType());
		
		switch (target.getType()) {
		case ACID:
			break;
		case BOMB:
			google.incrementAchievement(Achievements.MR_KAMIKAZE, 1);
			break;
		case RARE_FOOD:
			break;
		case SMALL_FOOD:
			break;
		case SNAKE:
			if (target.equals(snake.getTail())) {
				google.submitAchievement(Achievements.CIRCLE_OF_DEATH);
			}
			break;
		case TELEPORTER:
			google.submitAchievement(Achievements.BEAM_ME_UP_SCOTTIE);
			google.incrementAchievement(Achievements.THE_CAKE_IS_A_LIE, 1);
			break;
		default:
			break;
		}
		
		counter30.count();
		counter40.count();
		counter50.count();
		
		if (!target.getType().equals(WorldEntityType.SNAKE)) {
			google.incrementAchievement(Achievements.ACID_HUNTER, 1);
			google.incrementAchievement(Achievements.ACID_MASTER, 1);
			google.incrementAchievement(Achievements.ACID_LEGEND, 1);
		}
		
		if (!target.getType().equals(WorldEntityType.SNAKE)) {
			
			WorldEntityType type = target.getType();
			
			if (type.equals(WorldEntityType.RARE_FOOD)) {
				type = WorldEntityType.SMALL_FOOD;
			}
			
			collected.add(type);
			
			if (collected.size() >= 4) {
				google.submitAchievement(Achievements.QUADROCOPTER);
			}
		}		
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
	
	class BlockCounter extends WorldHandler {
		
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

		@Override
		public void onPaused(boolean state) {
			super.onPaused(state);
			
			if (state) {
				timer.pause();
			} else {
				timer.start();
			}
		}
	}
	
	
	
	class ComboDetector {
		
		private Map<WorldEntityType, Integer> combos;
		
		public ComboDetector() {
			combos = new HashMap<WorldEntityType, Integer>();
		}
		
		public void update(WorldEntityType type) {
			
			Integer value = combos.get(type);
			
			if (value == null) {
				combos.clear();
				value = 0;
			}
			
			combos.put(type, ++value);
		}
		
		public boolean hasCombo(WorldEntityType type, int steps) {
			return combos.get(type) != null && combos.get(type) >= steps;
		}
	}
}
