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
import de.myreality.acidsnake.world.WorldHandler;

/**
 * Listens to a snake to spawn particles on collisions
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class ParticleRenderer extends WorldHandler implements SnakeListener {

	// ===========================================================
	// Constants
	// ===========================================================
	
	private static final int SPECIAL_SNAKE_LENGTH = 15;

	// ===========================================================
	// Fields
	// ===========================================================
	
	private CellManager cellManager;
	
	private ParticleManager particleManager;
	
	private Map<WorldEntity, ParticleEffect> effects;
	
	private ParticleEffect snakeEffect;

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
		
		if (snakeEffect == null && snake.getLength() >= SPECIAL_SNAKE_LENGTH) {
			snakeEffect = particleManager.create(Resources.PARTICLE_FIELD_GREEN, true);
			snakeEffect.start();
			
			ParticleEffect effect = particleManager.create(Resources.PARTICLE_EXPLOSION_GREEN, false);
			alignOnIndex(indexX, indexY, effect);
			effect.start();
		} else if (snake.getLength() < SPECIAL_SNAKE_LENGTH) {
			particleManager.setEndless(snakeEffect, false);
			snakeEffect = null;
		}
		
		if (snake.getLength() >= SPECIAL_SNAKE_LENGTH) {
			alignOnIndex(snake.getIndexX(), snake.getIndexY(), snakeEffect);
		}
	}

	@Override
	public void onCollide(int indexX, int indexY, Snake snake,
			WorldEntity target) {
		
		ParticleEffect explodeEffect = target.getType().getExplodeEffect();
		
		if (explodeEffect != null) {
			ParticleEffect effect = particleManager.create(explodeEffect, false);
			alignOnIndex(indexX, indexY, effect);
			for (ParticleEmitter emitter : effect.getEmitters()) {
				emitter.setMaxParticleCount(emitter.getMaxParticleCount() / target.getType().getParticleDecreaseFactor());
			}
			
			effect.start();
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
		
	}


	@Override
	public void onPut(int indexX, int indexY, WorldEntity target, World world) {
		
		ParticleEffect effect = target.getType().getFieldEffect();
		
		if (effect != null) {
			effect = particleManager.create(target.getType().getFieldEffect(), true);
			alignOnIndex(indexX, indexY, effect);
			effect.start();
			effects.put(target, effect);
		}
	}

	@Override
	public void onRemove(int indexX, int indexY, WorldEntity target, World world) {
		if (effects.get(target) != null) {
			particleManager.setEndless(effects.get(target), false);
			effects.remove(target);
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
		if (effect != null) {
		effect.setPosition(
				cellManager.translateIndexX(indexX) + cellManager.getCellSize() / 2f, 
				Gdx.graphics.getHeight() - indexY * cellManager.getCellSize() - cellManager.getCellSize() / 2f);
		}
	}

	// ===========================================================
	// Inner classes
	// ===========================================================
}
