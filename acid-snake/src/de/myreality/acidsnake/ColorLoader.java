package de.myreality.acidsnake;

import com.badlogic.gdx.graphics.Color;

import de.myreality.chronos.resources.ResourceDefinition;
import de.myreality.chronos.resources.ResourceException;
import de.myreality.chronos.resources.ResourceType;
import de.myreality.chronos.resources.loader.AbstractResourceLoader;

@ResourceType("color")
public class ColorLoader extends AbstractResourceLoader<Color> {

	@Override
	public Color create(ResourceDefinition definition)
			throws ResourceException {
		return Color.valueOf(definition.getValue());
	}

	
}
