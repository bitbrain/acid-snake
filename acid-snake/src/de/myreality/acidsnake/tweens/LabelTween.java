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

package de.myreality.acidsnake.tweens;

import aurelienribon.tweenengine.TweenAccessor;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class LabelTween implements TweenAccessor<Actor> {

	public static final int ALPHA = 1;
	
	public static final int POPUP = 2;

	@Override
	public int getValues(Actor target, int tweenType, float[] returnValues) {
		switch (tweenType) {
		case ALPHA:
			returnValues[0] = target.getColor().a;
			return 1;
		case POPUP:
			returnValues[0] = target.getY();
			return 1;
		default:
			return 0;
		}
	}

	@Override
	public void setValues(Actor target, int tweenType, float[] newValues) {
		
		switch (tweenType) {
			case ALPHA:
				target.setColor(target.getColor().r, target.getColor().g, target.getColor().b, newValues[0]);
				break;
			case POPUP:
				target.setPosition(target.getX(), newValues[0]);
				break;
		}
	}

}
