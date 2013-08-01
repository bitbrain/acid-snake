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

import com.badlogic.gdx.graphics.Color;

/**
 * Class which fades between two colors
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 
 * @version 
 */
public class ColorFader {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private float srcR, srcG, srcB, dstR, dstG, dstB;	
	
	private double ratio;
	
	private Color color;

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public ColorFader(float srcR, float srcG, float srcB, float dstR,
			float dstG, float dstB) {
		super();
		this.srcR = srcR;
		this.srcG = srcG;
		this.srcB = srcB;
		this.dstR = dstR;
		this.dstG = dstG;
		this.dstB = dstB;
		color = new Color();
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================
	
	public void setRatio(double ratio) {
		this.ratio = ratio;
		ratio = Math.min(this.ratio, 1.0);
		ratio = Math.max(this.ratio, 0.0);
		
	}
	
	public Color getColor() {
		
		blend(srcR, srcG, srcB, dstR, dstG, dstB, ratio);
		
		return color;
	}

	// ===========================================================
	// Methods from Superclass
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================
	
	private void blend(float r1, float g1, float b1, float r2, float g2, float b2, double ratio) {
		double r = ratio;
		double ir = 1.0 - r;
		color.r = (float)(r1 * r + r2 * ir);
		color.g  = (float)(g1 * r + g2 * ir);
		color.b = (float)(b1 * r + b2 * ir);           
	}

	// ===========================================================
	// Inner classes
	// ===========================================================
}
