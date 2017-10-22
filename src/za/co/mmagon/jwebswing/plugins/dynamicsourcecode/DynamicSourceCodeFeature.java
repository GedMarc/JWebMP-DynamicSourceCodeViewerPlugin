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
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.plugins.jquery.JQueryPageConfigurator;

/**
 * Adds the dynamic source code JavaScript through
 *
 * @author MMagon
 * @version 1.0
 * @since 2013/01/16
 */
public class DynamicSourceCodeFeature<J extends DynamicSourceCodeFeature<J>> extends Feature<DynamicSourceCodeOptions, J>
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
	public DynamicSourceCodeFeature(DynamicSourceCodeScreen forComponent)
	{
		super("JWDynamicSourceCode");
		setComponent(forComponent);
		getJavascriptReferences().add(DynamicSourceCodeReferencePool.DynamicSourceCodeJavascript.getJavaScriptReference());
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
	public void preConfigure()
	{
		if (!isConfigured())
		{
			JQueryPageConfigurator.setRequired((Component) getComponent(), true);
		}
		super.preConfigure();
	}

	@Override
	public void assignFunctionsToComponent()
	{
		DynamicSourceCode source = (DynamicSourceCode) getComponent();
		addQuery("$('" + source.getID(true) + "').dynamicSourceCode(" + getOptions().toString() + ");" + getNewLine());

		source.getSourceChanges().forEach((key, value) -> addQuery("$('" + source.getID(true) + "').dynamicSourceCodeAddChanger('" + key.getID() + "','click');" + getNewLine()));
		source.getThemeChanges().forEach((key, value) -> addQuery("$('" + source.getID(true) + "').dynamicSourceCodeAddThemeChanger('" + key.getID() + "');" + getNewLine()));
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

	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + (getOptions() != null ? getOptions().hashCode() : 0);
		return result;
	}
}
