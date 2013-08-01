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

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import de.myreality.acidsnake.screens.IntroScreen;
import de.myreality.chronos.resources.ResourceException;
import de.myreality.chronos.resources.ResourceManager;
import de.myreality.chronos.resources.data.XMLSource;

public class SnakeGame extends Game {

	@Override
	public void create() {
		loadResources("resources.xml");
		setScreen(new IntroScreen(this));
	}
	
	private void loadResources(String assetPath) {
		FileHandle resourceFile = Gdx.files.internal(assetPath);
		ResourceManager resourceManager = ResourceManager.getInstance();	
		
		try {
			resourceManager.addResourceLoader(ColorLoader.class);
			resourceManager.addResourceLoader(TextureLoader.class);
			resourceManager.addResourceLoader(TextureAtlasLoader.class);
			resourceManager.addResourceLoader(BitmapFontLoader.class);
			resourceManager.load(new XMLSource(resourceFile.read()));
		} catch (ResourceException e) {
			e.printStackTrace();
		}
	}
	
}
