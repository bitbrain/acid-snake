package de.myreality.acidsnake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import de.myreality.chronos.resources.ResourceDefinition;
import de.myreality.chronos.resources.ResourceException;
import de.myreality.chronos.resources.ResourceType;
import de.myreality.chronos.resources.loader.AbstractResourceLoader;

@ResourceType("bitmap-font")
public class BitmapFontLoader extends AbstractResourceLoader<BitmapFont> {

	@Override
	public BitmapFont create(ResourceDefinition definition)
			throws ResourceException {
		FileHandle handle = Gdx.files.internal(definition.getValue());
		return new BitmapFont(handle, false);
	}

	
}
