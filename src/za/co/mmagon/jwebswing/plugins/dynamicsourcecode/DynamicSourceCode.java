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
package za.co.mmagon.jwebswing.plugins.dynamicsourcecode;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.plugins.google.sourceprettify.SourceCodePrettifyThemes;
import za.co.mmagon.jwebswing.utilities.StaticStrings;

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
public class DynamicSourceCode extends za.co.mmagon.jwebswing.plugins.google.sourceprettify.JQSourceCodePrettify
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
		getComponent().addAttribute(GlobalAttributes.Value, sourceClass.getCanonicalName().replace(StaticStrings.STRING_DOT, "/"));
		component.setID(sourceClass.getSimpleName() + "_source");
		getSourceChanges().put(component, sourceClass);
	}

	/**
	 * Registers a component as a theme changer
	 *
	 * @param component
	 * @param theme
	 */
	public void addThemeChanger(Component component, SourceCodePrettifyThemes theme)
	{
		getComponent().addAttribute(GlobalAttributes.Value, theme.getCssReference());
		component.setID(theme.name() + "_themeChanger");
		getThemeChanges().put(component, theme);
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
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof DynamicSourceCode))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		DynamicSourceCode that = (DynamicSourceCode) o;

		if (!getFeature().equals(that.getFeature()))
		{
			return false;
		}
		return getSourceChanges().equals(that.getSourceChanges()) && getThemes().equals(that.getThemes());
	}

	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + getFeature().hashCode();
		result = 31 * result + getSourceChanges().hashCode();
		result = 31 * result + getThemes().hashCode();
		return result;
	}
}
