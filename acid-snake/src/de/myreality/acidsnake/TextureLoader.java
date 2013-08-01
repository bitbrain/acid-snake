package de.myreality.acidsnake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

import de.myreality.chronos.resources.ResourceDefinition;
import de.myreality.chronos.resources.ResourceException;
import de.myreality.chronos.resources.ResourceType;
import de.myreality.chronos.resources.loader.AbstractResourceLoader;

@ResourceType("texture")
public class TextureLoader extends AbstractResourceLoader<Texture> {

	@Override
	public Texture create(ResourceDefinition definition)
			throws ResourceException {
		FileHandle handle = Gdx.files.internal(definition.getValue());
		
		if (!handle.exists()) {
			throw new ResourceException("Texture " + definition.getValue() + " does not exist");
		}
		
		return new Texture(handle);
	}

	
}
