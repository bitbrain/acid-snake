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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import de.myreality.acid.Acid;
import de.myreality.acid.BufferedRenderer;
import de.myreality.acidsnake.Resources;

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
	
	private static final int DURATION = 2000;
	
	private CellEffect fadeEffect;
	
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
		
		if (fadeEffect == null || fadeEffect.isDone()) {
			fadeEffect = new CellEffect(Resources.COLOR_GREEN, Resources.COLOR_VIOLET);
		}
		
		fadeEffect.update((int)Gdx.graphics.getDeltaTime());
		
		super.render();
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner classes
	// ===========================================================
	
	class CellEffect {
		
		private Color targetColor;
		
		public CellEffect(String ... colors) {
			
		}
		
		public void update(int delta) {
			
		}
		
		public boolean isDone() {
			return false;
		}
		
		private int blend(float r1, float g1, float b1, float r2, float g2, float b2, double ratio) {
			float r = (float) ratio;
			float ir = (float) 1.0 - r;
			return Color.rgb888(r1 * r + r2 * ir, 
							 g1 * r + g2 * ir,
							 b1 * r + b2 * ir);             
		}
	}
}
