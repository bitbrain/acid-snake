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

package de.myreality.acidsnake.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;

import de.myreality.acid.Acid;
import de.myreality.acid.gdx.GdxBufferedRenderer;
import de.myreality.acidsnake.SnakeGame;
import de.myreality.acidsnake.graphics.RandomAcid;

/**
 * Displays a fancy main menu
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class MainMenuScreen implements Screen {
	
	private SnakeGame game;
	
	private Acid background;
	
	public MainMenuScreen(SnakeGame game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		float color = 0.0f;
		Gdx.gl.glClearColor(color, color, color, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		background.render();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		background = new RandomAcid(new GdxBufferedRenderer());
		background.backgroundColor(0.1f, 0.1f, 0.1f);
		background.setSize(64);
		background.setIndexX(8);
		background.setIndexY(6);
		
		background.setPosition(Gdx.graphics.getWidth() / 2f - background.getWidth() / 2f, 
							   Gdx.graphics.getHeight() / 2f - background.getHeight() / 2f);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	
}
