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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

import de.myreality.acidsnake.Resources;
import de.myreality.acidsnake.core.Scoreable;

/**
 * UI element which shows up the total score
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.2
 * @version 1.2
 */
public class ScoreUI extends Table {

	// ===========================================================
	// Constants
	// ===========================================================
	
	private static final int PADDING = 30;

	// ===========================================================
	// Fields
	// ===========================================================
	
	private Scoreable scoreable;
	
	private Label lblPoints, lblLevel;
	
	private ScoreBar scoreBar;

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public ScoreUI() {
		
		this.setWidth(Gdx.graphics.getWidth());	
		setupUI();

		this.setHeight(lblPoints.getHeight() + PADDING);
		refreshUI(60f);
	}
	
	public ScoreUI(Scoreable scoreable) {
		this();
		setScoreable(scoreable);
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
	
	public void update(float delta) {
		refreshUI(delta);
	}
	
	private void refreshUI(float delta) {
		if (scoreable != null) {
			lblPoints.setText(scoreable.getPoints() + " points");
			lblLevel.setText("Level " + scoreable.getLevel());
		}
		
		
	}
	
	private void setupUI() {
		LabelStyle lblStyle = new LabelStyle();
		lblStyle.font = Resources.BITMAP_FONT_REGULAR;
		lblStyle.fontColor = Resources.COLOR_GREEN;
		
		lblPoints = new Label("0 points", lblStyle);
		
		left().add(lblPoints).padLeft(PADDING);
		lblLevel = new Label("Level 1", lblStyle);
		add(lblLevel).padLeft(PADDING);
		add(new ScoreBar());
		
	}
	
	public void setScoreable(Scoreable scoreable) {
		this.scoreable = scoreable;
	}

	// ===========================================================
	// Inner classes
	// ===========================================================
	
	class ScoreBar extends Table {
		
		public ScoreBar() {
			
		}
	}
}
