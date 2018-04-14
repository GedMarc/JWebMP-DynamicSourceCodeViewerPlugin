/*
 * Copyright (C) 2017 Marc Magon
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

import com.jwebmp.Component;
import com.jwebmp.base.html.attributes.GlobalAttributes;
import com.jwebmp.plugins.google.sourceprettify.SourceCodePrettifyThemes;
import com.jwebmp.utilities.StaticStrings;

import java.util.HashMap;
import java.util.Map;

/**
 * Custom code swapper for JQ Source Code Pretty
 * <p>
 *
 * @author Marc Magon
 * @version 1.0
 * @since 29 Aug 2015
 */
public class DynamicSourceCode
		extends com.jwebmp.plugins.google.sourceprettify.JQSourceCodePrettify
{

	private static final long serialVersionUID = 1L;
	private DynamicSourceCodeFeature feature;

	private Map<Component, Class> sourceChanges;
	private Map<Component, SourceCodePrettifyThemes> themes;

	public DynamicSourceCode()
	{
		addFeature(getFeature());
	}

	public final DynamicSourceCodeFeature getFeature()
	{
		if (feature == null)
		{
			feature = new DynamicSourceCodeFeature(this);
		}
		return feature;
	}

	/**
	 * Registers a component as a source code changer
	 *
	 * @param component
	 * @param sourceClass
	 */
	public void addSourceChanger(Component component, Class sourceClass)
	{
		component.addAttribute(GlobalAttributes.Value, sourceClass.getCanonicalName()
		                                                          .replace(StaticStrings.STRING_DOT, "/"));
		component.setID(sourceClass.getSimpleName() + "_source");
		getSourceChanges().put(component, sourceClass);
	}

	/**
	 * Returns all the source code changes
	 *
	 * @return
	 */
	public Map<Component, Class> getSourceChanges()
	{
		if (sourceChanges == null)
		{
			sourceChanges = new HashMap<>();
		}
		return sourceChanges;
	}

	/**
	 * Sets the source code changes
	 *
	 * @param sourceChanges
	 */
	public void setSourceChanges(Map<Component, Class> sourceChanges)
	{
		this.sourceChanges = sourceChanges;
	}

	/**
	 * Registers a component as a theme changer
	 *
	 * @param component
	 * @param theme
	 */
	public void addThemeChanger(Component component, SourceCodePrettifyThemes theme)
	{
		component.addAttribute(GlobalAttributes.Value.toString(), theme.getCssReference()
		                                                               .getLocalReference());
		component.setID(theme.name() + "_themeChanger");
		getThemeChanges().put(component, theme);
	}

	/**
	 * Gets the theme changes
	 *
	 * @return
	 */
	public Map<Component, SourceCodePrettifyThemes> getThemeChanges()
	{
		if (themes == null)
		{
			themes = new HashMap<>();
		}
		return themes;
	}

	/**
	 * Sets the theme changes
	 *
	 * @param themes
	 */
	public void setThemes(Map<Component, SourceCodePrettifyThemes> themes)
	{
		this.themes = themes;
	}

	@Override
	public DynamicSourceCodeOptions getOptions()
	{
		return getFeature().getOptions();
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}
}
