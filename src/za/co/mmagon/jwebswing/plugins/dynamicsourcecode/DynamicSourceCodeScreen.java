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

import java.util.HashMap;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.ListItem;
import za.co.mmagon.jwebswing.base.html.Option;
import za.co.mmagon.jwebswing.base.html.Select;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.attributes.OptionAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.htmlbuilder.css.displays.Overflows;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSSImpl;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementPercentages;
import za.co.mmagon.jwebswing.htmlbuilder.css.text.TextAlignments;
import za.co.mmagon.jwebswing.htmlbuilder.css.text.TextCSS;
import za.co.mmagon.jwebswing.plugins.ComponentInformation;
import za.co.mmagon.jwebswing.plugins.google.sourceprettify.JQSourceCodePrettify;
import za.co.mmagon.jwebswing.plugins.google.sourceprettify.SourceCodePrettifyThemes;

/**
 *
 * @author GedMarc
 * @param <J>
 *
 * @since 27 Apr 2015
 */
@ComponentInformation(name = "Dynamic Source Code Screen",
                      description = "A screen for a source code viewer with buttons to change the source displayed",
                      url = "https://github.com/GedMarc/JWebSwing-DynamicSourceCodeViewerPlugin", wikiUrl = "https://github.com/GedMarc/JWebSwing-DynamicSourceCodeViewerPlugin/wiki")
public class DynamicSourceCodeScreen<J extends DynamicSourceCodeScreen>
        extends Div<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
{

    private static final long serialVersionUID = 1L;
    private final HashMap<String, Class> screensToGenerate = new HashMap<>();
    @TextCSS(TextAlign = TextAlignments.Center)
    private final Div buttonPanel = new Div();
    private final JQSourceCodePrettify sourceDisplay = new JQSourceCodePrettify();

    public DynamicSourceCodeScreen()
    {
        setID("sourceScreen");
        getCss().getDimensions().setWidth(MeasurementPercentages.hundredPercent);
        getCss().getDimensions().setHeight(MeasurementPercentages.hundredPercent);
        getCss().getDisplay().setOverflow(Overflows.Hidden);
        buttonPanel.setID("actualSource");
        buttonPanel.getCss().getDimensions().setHeight(60);
        buttonPanel.getCss().getMargins().setMarginTop(new MeasurementCSSImpl(2));
        buttonPanel.addClass("sourceCodeButton");

        sourceDisplay.setID("sourceCode");
        sourceDisplay.setSourceCodePrettifyTheme(SourceCodePrettifyThemes.Sons_Of_Obsidian);
        addFeature(new DynamicSourceCodeFeature(this));

        sourceDisplay.getCss().getDimensions().setHeight(MeasurementPercentages.hundredPercent);
        sourceDisplay.getCss().getDisplay().setOverflow(Overflows.Scroll);

        za.co.mmagon.jwebswing.utilities.ComponentUtils.removeAllMargins(sourceDisplay);

        add(buttonPanel);
        add(sourceDisplay);
    }

    private Select getThemeSelector()
    {
        Select selectMenu = new Select();
        selectMenu.setID("prettySelect");
        selectMenu.getCss().getDimensions().setWidth(160);
        SourceCodePrettifyThemes[] themes = SourceCodePrettifyThemes.values();
        for (SourceCodePrettifyThemes theme : themes)
        {

            Option opt = new Option(theme.name().replace('_', ' '));
            opt.addAttribute(OptionAttributes.Value, theme.getCssReference());
            selectMenu.add(opt);

            ListItem li = new ListItem(theme.name().replace('_', ' '));
            li.addAttribute(GlobalAttributes.Value, theme.getCssReference());
        };

        return selectMenu;
    }

    public void addButton(String name, Class comp)
    {
        screensToGenerate.put(name, comp);
    }
}
