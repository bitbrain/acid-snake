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

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import de.myreality.acidsnake.tweens.LabelTween;

/**
 * Label which fades by using the tween engine
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class FadeLabel extends Label {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private float duration;

	// ===========================================================
	// Constructors
	// ===========================================================

	public FadeLabel(CharSequence text, float duration, TweenManager tweenManager, LabelStyle style) {
		super(text, style);
		initializeFading(duration, tweenManager);
	}

	public FadeLabel(CharSequence text, float duration, TweenManager tweenManager, Skin skin, String fontName, Color color) {
		super(text, skin, fontName, color);
		initializeFading(duration, tweenManager);
	}

	public FadeLabel(CharSequence text, float duration, TweenManager tweenManager, Skin skin, String fontName,
			String colorName) {
		super(text, skin, fontName, colorName);
		initializeFading(duration, tweenManager);
	}

	public FadeLabel(CharSequence text, float duration, TweenManager tweenManager, Skin skin, String styleName) {
		super(text, skin, styleName);
		initializeFading(duration, tweenManager);
	}

	public FadeLabel(CharSequence text, float duration, TweenManager tweenManager, Skin skin) {
		super(text, skin);
		initializeFading(duration, tweenManager);
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================
	
	private void initializeFading(float duration, final TweenManager tweenManager) {
		
		this.duration = duration;
		
		TweenCallback animationEnded = new TweenCallback() {

			@Override
			public void onEvent(int tweenId, BaseTween<?> tween) {
				startFading(tweenManager, this);
			}
		};
		
		startFading(tweenManager, animationEnded);
	}
	
	private void startFading(TweenManager tweenManager, TweenCallback callback) {
		Tween.to(this, LabelTween.ALPHA, duration / 2f)
	 	.target(0f)
		.ease(TweenEquations.easeInOutQuad)
		.repeatYoyo(1, 0f)
		.setCallback(callback)
		.setCallbackTriggers(TweenCallback.COMPLETE)
		.start(tweenManager);
	}

	// ===========================================================
	// Inner classes
	// ===========================================================
}
