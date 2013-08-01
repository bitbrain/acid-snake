package de.myreality.acidsnake;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import de.myreality.chronos.resources.ResourceDefinition;
import de.myreality.chronos.resources.ResourceException;
import de.myreality.chronos.resources.ResourceType;
import de.myreality.chronos.resources.loader.AbstractResourceLoader;

@ResourceType("texture-atlas")
public class TextureAtlasLoader extends AbstractResourceLoader<TextureAtlas> {

	@Override
	public TextureAtlas create(ResourceDefinition definition)
			throws ResourceException {
		return new TextureAtlas(definition.getValue());
	}

	
}
