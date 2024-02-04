/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.plugins.dynamicsourcecode;

import com.jwebmp.core.Feature;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.plugins.jquery.JQueryPageConfigurator;

import static com.guicedee.services.jsonrepresentation.json.StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON;
import static com.jwebmp.core.utilities.StaticStrings.*;

/**
 * Adds the dynamic source code JavaScript through
 *
 * @author MMagon
 * @version 1.0
 * @since 2013/01/16
 */
public class DynamicSourceCodeFeature<J extends DynamicSourceCodeFeature<J>>
		extends Feature<GlobalFeatures, DynamicSourceCodeOptions<?>, J>
{
	/**
	 * The list of options for the viewer
	 */
	private DynamicSourceCodeOptions<?> options;

	/**
	 * Constructs a new Feature for the Dynamic Source Code Component.
	 * <p>
	 *
	 * @param forComponent Only a dynamic source code
	 */
	public DynamicSourceCodeFeature(DynamicSourceCode<?> forComponent)
	{
		super("JWDynamicSourceCode");
		setComponent(forComponent);
		getJavascriptReferences().add(DynamicSourceCodeReferencePool.DynamicSourceCodeJavascript.getJavaScriptReference());
	}

	@Override
	public void preConfigure()
	{
		if (!isConfigured())
		{
			JQueryPageConfigurator.setRequired(true);
		}
		super.preConfigure();
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}

	/**
	 * Returns all the source code options options
	 * <p>
	 *
	 * @return
	 */
	@Override
	public DynamicSourceCodeOptions<?> getOptions()
	{
		if (options == null)
		{
			options = new DynamicSourceCodeOptions<>();
		}
		return options;
	}

	@Override
	public void assignFunctionsToComponent()
	{
		DynamicSourceCode<?> source = (DynamicSourceCode<?>) getComponent();
		addQuery("$('" + source.getID(true) + "').dynamicSourceCode(" + getOptions().toString() + STRING_CLOSING_BRACKET_SEMICOLON + getNewLine());

		source.getSourceChanges()
		      .forEach((key, value) -> addQuery("$('" + source.getID(true) + "').dynamicSourceCodeAddChanger('" + key.getID() + "','click');" + getNewLine()));
		source.getThemeChanges()
		      .forEach((key, value) -> addQuery("$('" + source.getID(true) + "').dynamicSourceCodeAddThemeChanger('" + key.getID() + "');" + getNewLine()));
	}
}
