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
import za.co.mmagon.jwebswing.plugins.google.sourceprettify.JQSourceCodePrettify;
import za.co.mmagon.jwebswing.plugins.google.sourceprettify.SourceCodePrettifyThemes;
import za.co.mmagon.jwebswing.plugins.jqxwidgets.dropdownlist.JQXDropDownListSelectMenu;
import za.co.mmagon.jwebswing.plugins.jqxwidgets.panel.JQXPanel;
import za.co.mmagon.jwebswing.plugins.jqxwidgets.panel.JQXPanelFeature;
import za.co.mmagon.jwebswing.plugins.jqxwidgets.panel.JQXPanelSizeModes;

/**
 *
 * @author GedMarc
 * @param <J>
 *
 * @since 27 Apr 2015
 */
public class DynamicSourceCodeScreen<J extends DynamicSourceCodeScreen>
        extends Div<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
{

    private static final long serialVersionUID = 1L;
    private final HashMap<String, Class> screensToGenerate = new HashMap<>();
    @TextCSS(TextAlign = TextAlignments.Center)
    private final JQXPanel buttonPanel = new JQXPanel();
    private final JQSourceCodePrettify sourceDisplay = new JQSourceCodePrettify();

    JQXPanelFeature feat = new JQXPanelFeature(sourceDisplay);

    public DynamicSourceCodeScreen()
    {
        setID("sourceScreen");
        getCss().getDimensions().setWidth(MeasurementPercentages.hundredPercent);
        getCss().getDimensions().setHeight(MeasurementPercentages.hundredPercent);
        getCss().getDisplay().setOverflow(Overflows.Hidden);
        buttonPanel.setID("actualSource");
        buttonPanel.getOptions().setHeight(60);
        buttonPanel.getCss().getDimensions().setHeight(60);
        buttonPanel.getOptions().setWidth(MeasurementPercentages.hundredPercent);
        buttonPanel.getCss().getMargins().setMarginTop(new MeasurementCSSImpl(2));
        buttonPanel.addClass("sourceCodeButton");

        sourceDisplay.setID("sourceCode");
        sourceDisplay.setSourceCodePrettifyTheme(SourceCodePrettifyThemes.Sons_Of_Obsidian);
        addFeature(new DynamicSourceCodeFeature(this));

        sourceDisplay.getCss().getDimensions().setHeight(MeasurementPercentages.hundredPercent);
        sourceDisplay.getCss().getDisplay().setOverflow(Overflows.Scroll);
        sourceDisplay.addFeature(feat);

        feat.getOptions().setSizeMode(JQXPanelSizeModes.fixed);
        feat.getOptions().setWidth(MeasurementPercentages.hundredPercent);
        feat.getOptions().setHeight(MeasurementPercentages.ninetyThreePercent);

        za.co.mmagon.jwebswing.utilities.ComponentUtils.removeAllMargins(sourceDisplay);

        add(buttonPanel);
        add(sourceDisplay);
    }

    private JQXDropDownListSelectMenu getThemeSelector()
    {
        JQXDropDownListSelectMenu selectMenu = new JQXDropDownListSelectMenu();
        selectMenu.setID("prettySelect");
        selectMenu.getOptions().setWidth(160);
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
