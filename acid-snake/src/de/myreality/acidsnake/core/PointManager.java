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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import de.myreality.acid.CellManager;
import de.myreality.acidsnake.Resources;
import de.myreality.acidsnake.google.AchievementListener;
import de.myreality.acidsnake.google.Achievements;
import de.myreality.acidsnake.ui.PopupManager;
import de.myreality.acidsnake.world.WorldEntity;
import de.myreality.acidsnake.world.WorldEntityType;

/**
 * Handles point displaying
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.3
 * @version 1.3
 */
public class PointManager implements SnakeListener, AchievementListener {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private CellManager cellManager;
	
	private PopupManager popupManager;
	
	private LabelStyle comboStyle, portalStyle, iceStyle;
	
	private float multiplier;

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public PointManager(CellManager cellManager, PopupManager popupManager) {
		this.cellManager = cellManager;
		this.popupManager = popupManager;
		comboStyle = new LabelStyle();
		comboStyle.font = Resources.BITMAP_FONT_REGULAR;
		comboStyle.fontColor = Resources.COLOR_ORANGE;
		portalStyle = new LabelStyle();
		portalStyle.font = Resources.BITMAP_FONT_REGULAR;
		portalStyle.fontColor = Resources.COLOR_BLUE;
		iceStyle = new LabelStyle();
		iceStyle.font = Resources.BITMAP_FONT_REGULAR;
		iceStyle.fontColor = Resources.COLOR_ICE; 
		multiplier = 1.0f;
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================

	@Override
	public void onEnterPosition(int indexX, int indexY, Snake snake) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCollide(int indexX, int indexY, Snake snake,
			WorldEntity target) {
		
		float x = translateIndexX(indexX);
		float y = translateIndexY(indexY);
		
		WorldEntityType type = target.getType();
		
		int points = (int) (type.getPoints() * multiplier);
		if (points > 0) {			
			snake.getWorld().getPlayer().addPoints(points);
			popupManager.popup(x, y, points + "");
			multiplier = 1.0f;
		}
	}

	@Override
	public void onKill(Snake snake) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSpawn(Snake snake) {
	}

	@Override
	public void onAchieve(String achievementID, int indexX, int indexY) {
		
		float x = translateIndexX(indexX);
		float y = translateIndexY(indexY) + 30;
		
		if (achievementID.equals(Achievements.COMBO_EXPERT)) {
			popupManager.popup(x, y, "Combo 2x", comboStyle);
			multiplier = 2;
		}
		
		if (achievementID.equals(Achievements.COMBO_SAIYAJIN)) {
			popupManager.popup(x, y, "Combo 3x", comboStyle);
			multiplier = 3;
		}
		
		if (achievementID.equals(Achievements.TIME_TRAVELLER)) {
			popupManager.popup(x, y, "Time Traveler", portalStyle);
			multiplier = 3;
		}
		
		if (achievementID.equals(Achievements.MASTER_OF_TIME)) {
			popupManager.popup(x, y, "Master Of Time", portalStyle);
			multiplier = 5;
		}
		
		if (achievementID.equals(Achievements.ICE_CRUSHER)) {
			popupManager.popup(x, y, "Ice Crusher", iceStyle);
			multiplier = 4;
		}
	}

	@Override
	public void onIncrementalAchieve(String achievementID, int indexX, int index) {
		
	}

	// ===========================================================
	// Methods
	// ===========================================================
	
	private float translateIndexX(int indexX) {
		return cellManager.translateIndexX(indexX) + cellManager.getCellSize() / 2f;
	}
	
	private float translateIndexY(int indexY) {
		return Gdx.graphics.getHeight() - indexY * cellManager.getCellSize() - cellManager.getCellSize() / 2f;
	}

	// ===========================================================
	// Inner classes
	// ===========================================================
}
