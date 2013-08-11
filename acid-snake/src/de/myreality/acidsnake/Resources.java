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
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

import de.myreality.acid.CellRenderer;
import de.myreality.acid.gdx.GdxBufferedRenderer;
import de.myreality.acid.gdx.GdxCellRenderer;

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
	
	public static Texture TEXTURE_ACID_LOGO;
	public static Texture TEXTURE_GAME_LOGO;
	public static Texture TEXTURE_BLOCK_GREEN;
	public static Texture TEXTURE_BLOCK_VIOLET;
	public static Texture TEXTURE_BLOCK_ORANGE;
	public static Texture TEXTURE_BLOCK_BLUE;
	public static Texture TEXTURE_BLOCK;
	public static Texture TEXTURE_ICON_ACHIEVEMENTS;
	public static Texture TEXTURE_ICON_SCORES;
	
	public static void reloadTextures() {
		
		if (TEXTURE_ACID_LOGO != null) {
			TEXTURE_ACID_LOGO.dispose();
		}
		
		if (TEXTURE_GAME_LOGO != null) {
			TEXTURE_GAME_LOGO.dispose();
		}
		
		if (TEXTURE_BLOCK_GREEN != null) {
			TEXTURE_BLOCK_GREEN.dispose();
		}
		
		if (TEXTURE_BLOCK_VIOLET != null) {
			TEXTURE_BLOCK_VIOLET.dispose();
		}
		
		if (TEXTURE_BLOCK_ORANGE != null) {
			TEXTURE_BLOCK_ORANGE.dispose();
		}
		
		if (TEXTURE_BLOCK_BLUE != null) {
			TEXTURE_BLOCK_BLUE.dispose();
		}
		
		if (TEXTURE_BLOCK != null) {
			TEXTURE_BLOCK.dispose();
		}
		
		if (TEXTURE_ICON_ACHIEVEMENTS != null) {
			TEXTURE_ICON_ACHIEVEMENTS.dispose();
		}
		
		if (TEXTURE_ICON_SCORES != null) {
			TEXTURE_ICON_SCORES.dispose();
		}
		
		TEXTURE_ACID_LOGO  = new Texture("data/banner.png");
		TEXTURE_GAME_LOGO = new Texture("data/logo.png");
		TEXTURE_BLOCK = new Texture("data/block.png");
		TEXTURE_BLOCK_GREEN = new Texture("data/block-green.png");
		TEXTURE_BLOCK_VIOLET = new Texture("data/block-violet.png");
		TEXTURE_BLOCK_ORANGE = new Texture("data/block-orange.png");
		TEXTURE_BLOCK_BLUE = new Texture("data/block-blue.png");
		TEXTURE_ICON_ACHIEVEMENTS = new Texture("data/icon-achievements.png");
		TEXTURE_ICON_SCORES = new Texture("data/icon-scores.png");
		
	}
	
	// ===========================================================
	// Shader
	// ===========================================================
	
	public static ShaderProgram SHADER_BLUR;
	
	public static void reloadShaders() {
		
		if (SHADER_BLUR != null) {
			SHADER_BLUR.dispose();
		}

		SHADER_BLUR = new ShaderProgram(Gdx.files.internal("data/blur.frag"), Gdx.files.internal("data/blur.vert"));
	}
	
	// ===========================================================
	// Colors
	// ===========================================================
	
	public static final Color COLOR_GREEN = Color.valueOf("8af500");	
	public static final Color COLOR_VIOLET = Color.valueOf("6f0076");
	public static final Color COLOR_ORANGE = Color.valueOf("ff3600");
	
	// ===========================================================
	// Strings
	// ===========================================================
	
	public static final String STRING_START_GAME = "Touch to start";

	// ===========================================================
	// Fonts
	// ===========================================================
		
	public static BitmapFont BITMAP_FONT_REGULAR;
	public static BitmapFont BITMAP_FONT_LARGE;
	
	public static void reloadFonts() {
		
		if (BITMAP_FONT_REGULAR != null) {
			BITMAP_FONT_REGULAR.dispose();
		}
		
		if (BITMAP_FONT_LARGE != null) {
			BITMAP_FONT_LARGE.dispose();
		}
		
		BITMAP_FONT_REGULAR = new BitmapFont(Gdx.files.internal("data/regular.fnt"), false);
		BITMAP_FONT_LARGE = new BitmapFont(Gdx.files.internal("data/large.fnt"), false);
	}
	
	// ===========================================================
	// Particles
	// ===========================================================
	
	public static ParticleEffect PARTICLE_EXPLOSION_GREEN = new ParticleEffect();
	public static ParticleEffect PARTICLE_EXPLOSION_ORANGE = new ParticleEffect();
	public static ParticleEffect PARTICLE_EXPLOSION_VIOLET = new ParticleEffect();
	public static ParticleEffect PARTICLE_EXPLOSION_BLUE = new ParticleEffect();
	
	public static ParticleEffect PARTICLE_FIELD_BLUE = new ParticleEffect();
	public static ParticleEffect PARTICLE_FIELD_ORANGE = new ParticleEffect();
	public static ParticleEffect PARTICLE_FIELD_GREEN = new ParticleEffect();
	public static ParticleEffect PARTICLE_FIELD_VIOLET = new ParticleEffect();
	
	public static void reloadParticles() {
		
		if (PARTICLE_EXPLOSION_GREEN != null) {
			PARTICLE_EXPLOSION_GREEN.dispose();
		}
		
		if (PARTICLE_EXPLOSION_ORANGE != null) {
			PARTICLE_EXPLOSION_ORANGE.dispose();
		}
		
		if (PARTICLE_EXPLOSION_VIOLET != null) {
			PARTICLE_EXPLOSION_VIOLET.dispose();
		}
		
		if (PARTICLE_FIELD_BLUE != null) {
			PARTICLE_FIELD_BLUE.dispose();
		}
		
		if (PARTICLE_EXPLOSION_BLUE != null) {
			PARTICLE_EXPLOSION_BLUE.dispose();
		}
		
		if (PARTICLE_FIELD_ORANGE != null) {
			PARTICLE_FIELD_ORANGE.dispose();
		}
		
		if (PARTICLE_FIELD_GREEN != null) {
			PARTICLE_FIELD_GREEN.dispose();
		}
		
		if (PARTICLE_FIELD_VIOLET != null) {
			PARTICLE_FIELD_VIOLET.dispose();
		}
		
		PARTICLE_EXPLOSION_GREEN.load(Gdx.files.internal("data/particleExplosionGreen.p"), 
	            Gdx.files.internal("data"));
		
		PARTICLE_EXPLOSION_ORANGE.load(Gdx.files.internal("data/particleExplosionOrange.p"), 
	            Gdx.files.internal("data"));
		
		PARTICLE_EXPLOSION_VIOLET.load(Gdx.files.internal("data/particleExplosionViolet.p"), 
	            Gdx.files.internal("data"));
		
		PARTICLE_EXPLOSION_BLUE.load(Gdx.files.internal("data/particleExplosionBlue.p"), 
	            Gdx.files.internal("data"));
		
		PARTICLE_FIELD_BLUE.load(Gdx.files.internal("data/particleFieldBlue.p"), 
	            Gdx.files.internal("data"));
		
		PARTICLE_FIELD_ORANGE.load(Gdx.files.internal("data/particleFieldOrange.p"), 
	            Gdx.files.internal("data"));
		
		PARTICLE_FIELD_GREEN.load(Gdx.files.internal("data/particleFieldGreen.p"), 
	            Gdx.files.internal("data"));
		
		PARTICLE_FIELD_VIOLET.load(Gdx.files.internal("data/particleFieldViolet.p"), 
	            Gdx.files.internal("data"));
	}
	
	// ===========================================================
	// Cell renderers
	// ===========================================================
	
	public static CellRenderer CELL_RENDERER_ORANGE;
	public static CellRenderer CELL_RENDERER_BLUE;
	public static CellRenderer CELL_RENDERER_GREEN;
	public static CellRenderer CELL_RENDERER_VIOLET;
	public static CellRenderer CELL_RENDERER_WHITE;
	
	public static final void reloadCellRenderer(GdxBufferedRenderer renderer) {
		CELL_RENDERER_ORANGE = new GdxCellRenderer(TEXTURE_BLOCK_ORANGE, renderer);
		CELL_RENDERER_BLUE = new GdxCellRenderer(TEXTURE_BLOCK_BLUE, renderer);
		CELL_RENDERER_GREEN = new GdxCellRenderer(TEXTURE_BLOCK_GREEN, renderer);
		CELL_RENDERER_VIOLET = new GdxCellRenderer(TEXTURE_BLOCK_VIOLET, renderer);
		CELL_RENDERER_WHITE = new GdxCellRenderer(TEXTURE_BLOCK, renderer);
	}
}
