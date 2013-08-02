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

package de.myreality.acidsnake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Contains resource locations
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class Resources {

	// ===========================================================
	// Textures
	// ===========================================================
	
	public static final Texture TEXTURE_ACID_LOGO = new Texture("data/banner.png");
	public static final Texture TEXTURE_GAME_LOGO = new Texture("data/logo.png");
	public static final Texture TEXTURE_BLOCK = new Texture("data/block.png");
	
	// ===========================================================
	// Colors
	// ===========================================================
	
	public static final Color COLOR_GREEN = Color.valueOf("8af500");
	
	public static final Color COLOR_VIOLET = Color.valueOf("6f0076");
	
	// ===========================================================
	// Strings
	// ===========================================================
	
	public static final String STRING_START_GAME = "Touch to start";

	// ===========================================================
	// Fonts
	// ===========================================================
		
	public static final BitmapFont BITMAP_FONT_REGULAR = new BitmapFont(Gdx.files.internal("data/regular.fnt"), false);
	
	
}
