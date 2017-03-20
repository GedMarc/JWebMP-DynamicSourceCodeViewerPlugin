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
import za.co.mmagon.jwebswing.plugins.google.sourceprettify.SourceCodePrettifyThemes;
import za.co.mmagon.jwebswing.plugins.jquery.JQueryPageConfigurator;

/**
 * Adds the dynamic source code JavaScript through
 *
 * @author MMagon
 * @since 2013/01/16
 * @version 1.0
 */
public class DynamicSourceCodeFeature extends Feature<DynamicSourceCodeOptions, DynamicSourceCodeFeature>
        implements GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private DynamicSourceCodeOptions options;

    /**
     * Constructs a new Feature for the Dynamic Source Code Component.
     * <p>
     * @param forComponent
     */
    public DynamicSourceCodeFeature(Component forComponent)
    {
        super("JWDynamicSourceCode");
        setComponent(forComponent);
        getJavascriptReferences().add(DynamicSourceCodeReferencePool.DynamicSourceCodeJavascript.getJavaScriptReference());
    }

    /**
     * Returns all the source code options options
     * <p>
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
        //System.out.println("Feature Assign - " + isInitialized() + " - " + source.isInitialized());
        addQuery("$('" + source.getID(true) + "').dynamicSourceCode(" + getOptions().toString() + ");" + getNewLine());

        source.getSourceChanges().entrySet().stream().map((entry) ->
        {
            Component key = entry.getKey();
            Class value = entry.getValue();

            return key;
        }).forEachOrdered((key) ->
        {
            addQuery("$('" + source.getID(true) + "').dynamicSourceCodeAddChanger('" + key.getID() + "','click');" + getNewLine());
        });

        source.getThemeChanges().entrySet().stream().map((entry) ->
        {
            Component key = entry.getKey();
            SourceCodePrettifyThemes value = entry.getValue();

            return key;
        }).forEachOrdered((key) ->
        {
            addQuery("$('" + source.getID(true) + "').dynamicSourceCodeAddThemeChanger('" + key.getID() + "');" + getNewLine());
        });
    }
}
