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

import com.badlogic.gdx.scenes.scene2d.Actor;

import de.myreality.acidsnake.core.Player;
import de.myreality.acidsnake.core.PlayerListener;
import de.myreality.acidsnake.tweens.LabelTween;

/**
 * Animates a progress bar for a specific player
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.3
 * @version 1.3
 */
public class PlayerActorAnimator implements PlayerListener {	

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private TweenManager tweenManager;
	
	private Actor actor;

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public PlayerActorAnimator(Actor actor, TweenManager manager) {
		this.tweenManager = manager;
		this.actor = actor;
		Tween.registerAccessor(Actor.class, new LabelTween());
		actor.setColor(1f, 1f, 1f, 0.5f);
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================
	
	@Override
	public void onPointsAdd(int points, int level, Player player) {
		tweenManager.killTarget(actor);
		actor.setColor(1f, 1f, 1f, 1f);
		Tween.to(actor, LabelTween.ALPHA, 3)
	 	.target(0.5f)
		.ease(TweenEquations.easeInOutQuad)
		.start(tweenManager);
	}

	@Override
	public void onLevelUp(int oldLevel, int newLevel, Player player) {
		
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner classes
	// ===========================================================
}
