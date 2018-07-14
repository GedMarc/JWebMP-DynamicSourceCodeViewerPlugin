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

import com.jwebmp.Feature;
import com.jwebmp.base.ComponentHierarchyBase;
import com.jwebmp.base.html.interfaces.GlobalFeatures;
import com.jwebmp.plugins.jquery.JQueryPageConfigurator;

import static com.jwebmp.utilities.StaticStrings.*;

/**
 * Adds the dynamic source code JavaScript through
 *
 * @author MMagon
 * @version 1.0
 * @since 2013/01/16
 */
public class DynamicSourceCodeFeature<J extends DynamicSourceCodeFeature<J>>
		extends Feature<DynamicSourceCodeOptions, J>
		implements GlobalFeatures
{

	private static final long serialVersionUID = 1L;
	/**
	 * The list of options for the viewer
	 */
	private DynamicSourceCodeOptions options;

	/**
	 * Constructs a new Feature for the Dynamic Source Code Component.
	 * <p>
	 *
	 * @param forComponent
	 */
	public DynamicSourceCodeFeature(ComponentHierarchyBase forComponent)
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
		int result = super.hashCode();
		result = 31 * result + (getOptions() != null ? getOptions().hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof DynamicSourceCodeFeature))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		DynamicSourceCodeFeature<?> that = (DynamicSourceCodeFeature<?>) o;

		return getOptions() != null ? getOptions().equals(that.getOptions()) : that.getOptions() == null;
	}

	/**
	 * Returns all the source code options options
	 * <p>
	 *
	 * @return
	 */
	@Override
	public DynamicSourceCodeOptions getOptions()
	{
		if (options == null)
		{
			options = new DynamicSourceCodeOptions();
		}
		return options;
	}

	@Override
	public void assignFunctionsToComponent()
	{
		DynamicSourceCode source = (DynamicSourceCode) getComponent();
		addQuery("$('" + source.getID(true) + "').dynamicSourceCode(" + getOptions().toString() + STRING_CLOSING_BRACKET_SEMICOLON + getNewLine());

		source.getSourceChanges()
		      .forEach((key, value) -> addQuery("$('" + source.getID(true) + "').dynamicSourceCodeAddChanger('" + key.getID() + "','click');" + getNewLine()));
		source.getThemeChanges()
		      .forEach((key, value) -> addQuery("$('" + source.getID(true) + "').dynamicSourceCodeAddThemeChanger('" + key.getID() + "');" + getNewLine()));
	}
}
