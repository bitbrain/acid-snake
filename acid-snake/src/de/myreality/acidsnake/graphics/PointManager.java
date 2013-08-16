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

package de.myreality.acidsnake.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import de.myreality.acid.CellManager;
import de.myreality.acidsnake.Resources;
import de.myreality.acidsnake.core.Snake;
import de.myreality.acidsnake.core.SnakeListener;
import de.myreality.acidsnake.google.AchievementListener;
import de.myreality.acidsnake.google.Achievements;
import de.myreality.acidsnake.ui.PopupManager;
import de.myreality.acidsnake.world.WorldEntity;

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
	
	private LabelStyle comboStyle;

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public PointManager(CellManager cellManager, PopupManager popupManager) {
		this.cellManager = cellManager;
		this.popupManager = popupManager;
		comboStyle = new LabelStyle();
		comboStyle.font = Resources.BITMAP_FONT_REGULAR;
		comboStyle.fontColor = Resources.COLOR_ORANGE;
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
		
		if (target.getType().getPoints() > 0) {
			popupManager.popup(x, y, target.getType().getPoints() + "");
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
		float y = translateIndexY(indexY);
		
		if (achievementID.equals(Achievements.COMBO_EXPERT)) {
			popupManager.popup(x, y, "Combo 2x", comboStyle);
		}
		
		if (achievementID.equals(Achievements.COMBO_SAIYAJIN)) {
			popupManager.popup(x, y, "Combo 3x", comboStyle);
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
