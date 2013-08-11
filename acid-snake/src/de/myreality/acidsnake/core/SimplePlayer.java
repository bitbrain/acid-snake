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

import de.myreality.acidsnake.util.Timer;

/**
 * Implementation of {@link Player}
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class SimplePlayer implements Player {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private Timer timer;
	
	private int points;
	
	private int level;

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public SimplePlayer() {
		level = 1;
		timer = new Timer();
		timer.start();
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================

	@Override
	public int getPoints() {
		return points;
	}

	@Override
	public void resetPoints() {
		points = 0;
	}

	@Override
	public void addPoints(int points) {
		setPoints(getPoints() + points);
	}

	@Override
	public void setPoints(int points) {
		this.points = points;
		
		level = calculateLevel(points);
	}

	@Override
	public String getTime() {
		return timer.toString();
	}

	@Override
	public void resetTime() {
		timer.reset();
	}

	@Override
	public int getLevel() {
		return level;
	}

	// ===========================================================
	// Methods
	// ===========================================================
	
	private int calculateLevel(int points) {
		return points / 200 + 1;
	}

	@Override
	public void setPaused(boolean paused) {
		if (paused) {
			timer.pause();
		} else {
			timer.start();
		}
	}

	// ===========================================================
	// Inner classes
	// ===========================================================
}
