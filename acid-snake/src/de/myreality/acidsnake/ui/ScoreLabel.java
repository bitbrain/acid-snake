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

package de.myreality.acidsnake.ui;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import de.myreality.acidsnake.core.Scoreable;
import de.myreality.acidsnake.tweens.LabelTween;

/**
 * Shows a score of a scoreable
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.3
 * @version 1.3
 */
public class ScoreLabel extends Label {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private Scoreable scoreable;
	
	private TweenManager tweenManager;
	
	private int currentPoints;
	
	private boolean fadingAllowed;

	// ===========================================================
	// Constructors
	// ===========================================================

	public ScoreLabel(Scoreable scoreable, TweenManager tweenManager, LabelStyle style) {
		super("" + scoreable.getPoints(), style);
		this.scoreable = scoreable;
		this.tweenManager = tweenManager;
		Tween.registerAccessor(Label.class, new LabelTween());
		setColor(1f, 1f, 1f, 0.5f);
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		
		if (currentPoints < scoreable.getPoints()) {
			
			if (fadingAllowed) {
				tweenManager.killTarget(this);
				setColor(1f, 1f, 1f, 1f);
				Tween.to(this, LabelTween.ALPHA, 3)
			 	.target(0.5f)
				.ease(TweenEquations.easeInOutQuad)
				.start(tweenManager);
			}
			
			currentPoints++;
			fadingAllowed = false;
		} else {
			fadingAllowed = true;
		}
		
		setText("" + currentPoints);
		super.draw(batch, parentAlpha);
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner classes
	// ===========================================================
}
