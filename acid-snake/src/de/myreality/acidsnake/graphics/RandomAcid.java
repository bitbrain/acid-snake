/* AcidSnake - Snake game using Acid
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

import de.myreality.acid.Acid;
import de.myreality.acid.BufferedRenderer;
import de.myreality.acid.CellRenderer;
import de.myreality.acid.gdx.GdxCellRenderer;
import de.myreality.acidsnake.Resources;
import de.myreality.acidsnake.util.ColorFader;
import de.myreality.acidsnake.util.Timer;

/**
 * 
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 
 * @version 
 */
public class RandomAcid extends Acid {

	// ===========================================================
	// Constants
	// ===========================================================
	
	private CellEffect[][] fadeEffects;
	
	private int randomWaitTime = 56000;
	
	private int randomFadeTime = 5600;
	
	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	public RandomAcid(BufferedRenderer renderer) {
		super(renderer);
	}
	
	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================
	
	@Override
	public void render() {	
	
		if (fadeEffects == null) {
			fadeEffects = new CellEffect[getIndexX()][getIndexY()];
			
		}
		
		for (int x = 0; x < getIndexX(); ++x) {
			for (int y = 0; y < getIndexY(); ++y) {
				if (fadeEffects[x][y] == null) {
					fadeEffects[x][y] = new CellEffect(x, y, this);
				}
				
				fadeEffects[x][y].update();
			}
		}
		
		super.render();
	}
	

	
	public void setRandomWaitTime(int time) {
		randomWaitTime = time;
	}
	
	public int getRandomWaitTime() {
		return randomWaitTime;
	}
	
	public void setRandomFadeTime(int time) {
		randomFadeTime = time;
	}
	
	public int getRandomFadeTime() {
		return randomFadeTime;
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner classes
	// ===========================================================
	
	class CellEffect {
		
		private Color targetColor;
		
		private Timer timer, refreshTimer, waitTimer;
		
		private ColorFader fader;
		
		private long fadeTime;
		
		private static final int REFRESH_INTERVAL = 20;
		
		private int indexX, indexY;
		
		private int waitTime;
		
		private boolean waitMode;
		
		private Acid acid;
		
		public CellEffect(int indexX, int indexY, Acid acid) {
			
			timer = new Timer();
			refreshTimer = new Timer();
			waitTimer = new Timer();
			this.indexX = indexX;
			this.indexY = indexY;
			this.acid = acid;
			reloadColor();
			waitMode = true;
		}
		
		public void update() {
			
			if (waitMode) {
				
				if (!waitTimer.isRunning()) {
					resetWaitTime();
					waitTimer.start();
				}
				
				if (waitTimer.getTicks() >= waitTime) {
					resetFadeTime();
					waitTimer.stop();
					waitMode = false;
				}
			} else {
				if (!timer.isRunning()) {
					resetFadeTime();
					timer.start();
				}
				
				if (!refreshTimer.isRunning()) {
					refreshTimer.reset();
					refreshTimer.start();
				}
				
				if (refreshTimer.getTicks() >= REFRESH_INTERVAL) {
					fader.setRatio(timer.getTicks() / (float) fadeTime);
					Color color = fader.getColor();
					acid.color(color.r, color.g, color.b);
					acid.put(indexX, indexY);
					refreshTimer.reset();
				}
				
				if (timer.getTicks() >= fadeTime) {
					waitMode = true;
					acid.clear(indexX, indexY);
				}
			}
		}
		
		private Color generateRandomColor(Color ... colorCollection) {
			return colorCollection[(int)(colorCollection.length * Math.random())];
		}
		
		private void resetWaitTime() {
			waitTime = (int) (Math.random() * getRandomWaitTime() + 100);
			waitTimer.reset();
		}
		
		private void resetFadeTime() {
			fadeTime = (int) (Math.random() * getRandomFadeTime() + 200);
			reloadColor();
			timer.reset();
		}
		
		private void reloadColor() {
			targetColor = generateRandomColor(Resources.COLOR_GREEN, Resources.COLOR_VIOLET);
			fader = new ColorFader(0.01f, 0.01f, 0.01f, targetColor.r, targetColor.g, targetColor.b);
		}
	}
}
