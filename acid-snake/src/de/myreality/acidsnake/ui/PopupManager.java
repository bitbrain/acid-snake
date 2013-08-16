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

import java.util.LinkedList;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import de.myreality.acidsnake.tweens.LabelTween;

/**
 * Handles popups during gameplay
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.3
 * @version 1.3
 */
public class PopupManager implements TweenCallback {

	// ===========================================================
	// Constants
	// ===========================================================
	
	private static final int MOVING_DISTANCE = 300;

	// ===========================================================
	// Fields
	// ===========================================================
	
	private TweenManager tweenManager;
	
	private Stage stage;
	
	private LabelStyle popupStyle;

	private float duration;
	
	private LinkedList<Label> queue;

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public PopupManager(Stage stage, TweenManager tweenManager, LabelStyle popupStyle) {
		this.tweenManager = tweenManager;
		this.stage = stage;
		this.popupStyle = popupStyle;
		duration = 2f;
		queue = new LinkedList<Label>();
		Tween.registerAccessor(Label.class, new LabelTween());
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================

	@Override
	public void onEvent(int type, BaseTween<?> source) {
		Label label = queue.remove();
		tweenManager.killTarget(label);
		label.remove();
		label.invalidate();
	}

	// ===========================================================
	// Methods
	// ===========================================================
	
	public void popup(float x, float y, String text) {
		Label label = new Label(text, popupStyle);
		stage.addActor(label);
		label.setPosition(x - label.getWidth() / 2f, y - label.getHeight() / 2f);
		
		Tween.to(label, LabelTween.ALPHA, duration)
	 	.target(0f)
		.ease(TweenEquations.easeInOutQuad)
		.setCallback(this)
		.setCallbackTriggers(TweenCallback.COMPLETE)
		.start(tweenManager);
		Tween.to(label, LabelTween.POPUP, duration)
	 	.target(y - MOVING_DISTANCE)
		.ease(TweenEquations.easeInOutQuad)
		.start(tweenManager);
		queue.add(label);
	}
	
	public void setDurartion(float duration) {
		this.duration = duration;
	}

	// ===========================================================
	// Inner classes
	// ===========================================================
}
