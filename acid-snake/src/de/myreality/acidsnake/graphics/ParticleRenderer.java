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

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.myreality.acid.CellManager;
import de.myreality.acidsnake.Resources;
import de.myreality.acidsnake.core.Snake;
import de.myreality.acidsnake.core.SnakeListener;
import de.myreality.acidsnake.world.World;
import de.myreality.acidsnake.world.WorldEntity;
import de.myreality.acidsnake.world.WorldListener;

/**
 * Listens to a snake to spawn particles on collisions
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class ParticleRenderer implements SnakeListener, WorldListener {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private CellManager cellManager;
	
	private ParticleManager particleManager;
	
	private Map<WorldEntity, ParticleEffect> effects;

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public ParticleRenderer(CellManager manager) {
		this.cellManager = manager;
		particleManager = new ParticleManager();
		effects = new HashMap<WorldEntity, ParticleEffect>();
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
			ParticleEffect effect = particleManager.create(Resources.PARTICLE_EXPLOSION_VIOLET, false);
			alignOnIndex(indexX, indexY, effect);
			
			for (ParticleEmitter emitter : effect.getEmitters()) {
				emitter.setMaxParticleCount(emitter.getMaxParticleCount() / 5);
			}
			
			effect.reset();
			break;
		case RARE_FOOD:
			effect = particleManager.create(Resources.PARTICLE_EXPLOSION_VIOLET, false);
			alignOnIndex(indexX, indexY, effect);
			effect.reset();
			break;
		case SNAKE:
			break;
		case TELEPORTER:
			effect = particleManager.create(Resources.PARTICLE_EXPLOSION_BLUE, false);
			alignOnIndex(indexX, indexY, effect);
			effect.reset();
			break;
		default:
			break;
		
		}
	}
	
	// ===========================================================
	// World methods
	// ===========================================================

	@Override
	public void onKill(Snake snake) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSpawn(Snake snake) {
		// TODO Auto-generated method stub

	}


	@Override
	public void onPut(int indexX, int indexY, WorldEntity target, World world) {
		
		ParticleEffect effect = null;
		
		switch (target.getType()) {
		case RARE_FOOD:
			effect = particleManager.create(Resources.PARTICLE_FIELD_VIOLET, true);
			alignOnIndex(indexX, indexY, effect);
			effect.start();
			effects.put(target, effect);
			break;
		case SMALL_FOOD:
			break;
		case SNAKE:
			break;
		case TELEPORTER:
			effect = particleManager.create(Resources.PARTICLE_FIELD_BLUE, true);
			alignOnIndex(indexX, indexY, effect);
			effect.start();
			effects.put(target, effect);
			break;
		default:
			break;
		
		}
	}

	@Override
	public void onRemove(int indexX, int indexY, WorldEntity target, World world) {
		switch (target.getType()) {
		case RARE_FOOD:
			particleManager.setEndless(effects.get(target), false);
			effects.remove(target);
			break;
		case SMALL_FOOD:
			break;
		case SNAKE:
			break;
		case TELEPORTER:
			particleManager.setEndless(effects.get(target), false);
			effects.remove(target);
			break;
		default:
			break;
		
		}
	}

	@Override
	public void onBuild(World world) {
		// TODO Auto-generated method stub
		
	}

	// ===========================================================
	// Methods
	// ===========================================================
	
	public void render(SpriteBatch batch, float delta) {
		particleManager.render(batch, delta);
	}
	
	private void alignOnIndex(int indexX, int indexY, ParticleEffect effect) {
		effect.setPosition(
				cellManager.translateIndexX(indexX) + cellManager.getCellSize() / 2f, 
				Gdx.graphics.getHeight() - indexY * cellManager.getCellSize() - cellManager.getCellSize() / 2f);
	}

	// ===========================================================
	// Inner classes
	// ===========================================================
}
