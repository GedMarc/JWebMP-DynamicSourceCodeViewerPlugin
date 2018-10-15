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

import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.attributes.NoAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.htmlbuilder.css.displays.Overflows;
import com.jwebmp.core.htmlbuilder.css.measurement.MeasurementCSSImpl;
import com.jwebmp.core.htmlbuilder.css.measurement.MeasurementPercentages;
import com.jwebmp.core.htmlbuilder.css.text.TextAlignments;
import com.jwebmp.core.htmlbuilder.css.text.TextCSS;
import com.jwebmp.core.plugins.ComponentInformation;
import com.jwebmp.plugins.google.sourceprettify.JQSourceCodePrettify;
import com.jwebmp.plugins.google.sourceprettify.SourceCodePrettifyThemes;

import java.util.HashMap;
import java.util.Map;

/**
 * @param <J>
 *
 * @author GedMarc
 * @since 27 Apr 2015
 */
@ComponentInformation(name = "Dynamic Source Code Screen",
		description = "A screen for a source code viewer with buttons to change the source displayed",
		url = "https://github.com/GedMarc/JWebMP-DynamicSourceCodeViewerPlugin",
		wikiUrl = "https://github.com/GedMarc/JWebMP-DynamicSourceCodeViewerPlugin/wiki")
public class DynamicSourceCodeScreen<J extends DynamicSourceCodeScreen<J>>
		extends Div<IComponentHierarchyBase, NoAttributes, GlobalFeatures, GlobalEvents, J>
{

	private static final long serialVersionUID = 1L;
	private final Map<String, Class> screensToGenerate = new HashMap<>();
	@TextCSS(TextAlign = TextAlignments.Center)
	private final Div buttonPanel = new Div();
	private final JQSourceCodePrettify sourceDisplay;

	/**
	 * The source code sreen
	 */
	public DynamicSourceCodeScreen()
	{
		setID("sourceScreen");
		getCss().getDimensions()
		        .setWidth(MeasurementPercentages.hundredPercent);
		getCss().getDimensions()
		        .setHeight(MeasurementPercentages.hundredPercent);
		getCss().getDisplay()
		        .setOverflow(Overflows.Hidden);
		buttonPanel.setID("actualSource");
		buttonPanel.getCss()
		           .getDimensions()
		           .setHeight(60);
		buttonPanel.getCss()
		           .getMargins()
		           .setMarginTop(new MeasurementCSSImpl(2));
		buttonPanel.addClass("sourceCodeButton");

		sourceDisplay = new JQSourceCodePrettify();
		sourceDisplay.setID("sourceCode");
		sourceDisplay.setTheme(SourceCodePrettifyThemes.Sons_Of_Obsidian);
		addFeature(new DynamicSourceCodeFeature(this));

		sourceDisplay.getCss()
		             .getDimensions()
		             .setHeight(MeasurementPercentages.hundredPercent);
		sourceDisplay.getCss()
		             .getDisplay()
		             .setOverflow(Overflows.Scroll);

		add(buttonPanel);
		add(sourceDisplay);
	}

	/**
	 * Adds an open source code display button
	 *
	 * @param name
	 * @param comp
	 */
	public void addButton(String name, Class comp)
	{
		screensToGenerate.put(name, comp);
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
