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

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import de.myreality.acidsnake.Resources;
import de.myreality.acidsnake.core.Player;

/**
 * Shows information/statistics of the player's game
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class PlayerTable extends Table {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public PlayerTable(Player player) {
		
		LabelStyle valueStyle = new LabelStyle();
		valueStyle.font = Resources.BITMAP_FONT_LARGE;
		valueStyle.fontColor = Resources.COLOR_GREEN;
		
		LabelStyle infoStyle = new LabelStyle();
		infoStyle.font = Resources.BITMAP_FONT_LARGE;
		infoStyle.fontColor = Resources.COLOR_VIOLET;
		
		// LEVEL
		Label lblLevel = new Label(player.getLevel() + "", valueStyle);
		Label lblLevelInfo = new Label("Level: ", infoStyle);
		add(lblLevelInfo).left();
		add(lblLevel).left();
		row();
		
		// POINTS
		Label lblPoints = new Label(player.getPoints() + "", valueStyle);
		Label lblPointsInfo = new Label("Points: ", infoStyle);
		add(lblPointsInfo).left();
		add(lblPoints).left();
		row();
		
		// TIME
		Label lblTime = new Label(player.getTime(), valueStyle);
		Label lblTimeInfo = new Label("Time: ", infoStyle);
		add(lblTimeInfo).left();
		add(lblTime).left();
		row();
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

	// ===========================================================
	// Inner classes
	// ===========================================================
}
