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

package de.myreality.acidsnake.util;

import java.util.concurrent.TimeUnit;

/**
 * Simple timer implementation
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class Timer {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private long startTime;

	private boolean running;
	
	private long pauseTime;
	
	private long currentTicks;
	
	// ===========================================================
	// Constructors
	// ===========================================================
	
	public Timer() {
		reset();
		running = false;
	}
	
	public Timer(long miliseconds) {
		startTime = System.currentTimeMillis() + miliseconds;
		currentTicks = 0;
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================
	
	@Override
	public String toString() {
		return convertValue(TimeUnit.MILLISECONDS.toMinutes(getTicks())) + ":" +
		convertValue(TimeUnit.MILLISECONDS.toSeconds(getTicks()) - 
			    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(getTicks()))
			);
	}

	// ===========================================================
	// Methods
	// ===========================================================
	
	public void start() {
		running = true;
		
		if (pauseTime > 0) {
			startTime = System.currentTimeMillis() + pauseTime;
			pauseTime = 0;
		}
	}
	
	public void stop() {
		running = false;
		reset();
	}
	
	public void pause() {
		running = false;
		pauseTime = getTicks();
	}
	
	public void reset() {
		startTime = System.currentTimeMillis();
	}
	
	public long getTicks() {
		
		if (running) {
			currentTicks = System.currentTimeMillis() - startTime;
		}
		
		return currentTicks;
	}
	
	public boolean isRunning() {
		return running;
	}

	private String convertValue(long time) {
		if (time < 10) {
			return "0" + time;
		} else {
			return "" + time;
		}
	}

	// ===========================================================
	// Inner classes
	// ===========================================================
	
}
