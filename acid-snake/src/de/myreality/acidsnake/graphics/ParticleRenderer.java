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
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.myreality.acid.CellManager;
import de.myreality.acidsnake.Resources;
import de.myreality.acidsnake.core.Snake;
import de.myreality.acidsnake.core.SnakeListener;
import de.myreality.acidsnake.world.WorldEntity;

/**
 * Listens to a snake to spawn particles on collisions
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class ParticleRenderer implements SnakeListener {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private CellManager manager;
	
	private ParticleManager particleManager;

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public ParticleRenderer(CellManager manager) {
		this.manager = manager;
		particleManager = new ParticleManager();
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================

	@Override
	public void onEnterPosition(int indexX, int indexY, Snake snake) {
		
	}

	@Override
	public void onCollide(int indexX, int indexY, Snake snake,
			WorldEntity target) {
		switch (target.getType()) {
		case SMALL_FOOD:
			ParticleEffect effect = particleManager.create(Resources.PARTICLE_EXPLOSION_ORANGE, false);
			effect.setPosition(
					manager.translateIndexX(indexX), 
					Gdx.graphics.getHeight() - indexY * manager.getCellSize());
			effect.reset();
			break;
		case RARE_FOOD:
			effect = particleManager.create(Resources.PARTICLE_EXPLOSION_VIOLET, false);
			effect.setPosition(
					manager.translateIndexX(indexX), 
					Gdx.graphics.getHeight() - indexY * manager.getCellSize());
			effect.reset();
			break;
		case SNAKE:
			break;
		case TELEPORTER:
			effect = particleManager.create(Resources.PARTICLE_EXPLOSION_BLUE, false);
			effect.setPosition(
					manager.translateIndexX(indexX), 
					Gdx.graphics.getHeight() - indexY * manager.getCellSize());
			effect.reset();
			break;
		default:
			break;
		
		}
	}

	@Override
	public void onKill(Snake snake) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSpawn(Snake snake) {
		// TODO Auto-generated method stub

	}

	// ===========================================================
	// Methods
	// ===========================================================
	
	public void render(SpriteBatch batch, float delta) {
		particleManager.render(batch, delta);
	}

	// ===========================================================
	// Inner classes
	// ===========================================================
}
