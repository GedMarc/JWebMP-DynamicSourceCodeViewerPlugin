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

import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.PageConfigurator;
import za.co.mmagon.jwebswing.plugins.PluginInformation;

/**
 *
 * @author GedMarc
 * @since 28 Feb 2017
 *
 */
@PluginInformation(pluginName = "Source Code View", pluginUniqueName = "jw-source-code-viewer",
                   pluginDescription = "A basic screen with buttons to load sources, a format drop down, and a source display screen. Completely themable with a switch",
                   pluginVersion = "1.0.0",
                   pluginDependancyUniqueIDs = "jquery,google-code-prettify",
                   pluginCategories = "jquery, ui, source display, web, framework",
                   pluginSubtitle = "A custom built widget that provides a source code viewer, which will load and display source from pretty much anywhere",
                   pluginGitUrl = "https://github.com/GedMarc/JWebSwing-DynamicSourceCodeViewerPlugin",
                   pluginSourceUrl = "https://github.com/GedMarc/JWebSwing-DynamicSourceCodeViewerPlugin",
                   pluginWikiUrl = "https://github.com/GedMarc/JWebSwing-DynamicSourceCodeViewerPlugin/wiki",
                   pluginOriginalHomepage = "http://www.jwebswing.com/",
                   pluginIconUrl = "dynamicSourceCodeFetcher/dynamicviewerlogo.png",
                   pluginIconImageUrl = "dynamicSourceCodeFetcher/dynamicviewerlogo.png",
                   pluginDownloadUrl = "https://sourceforge.net/projects/jwebswing/files/plugins/DynamicSourceCodeViewerPlugin.jar/download",
                   pluginCommercial = false)
public class DynamicSourceCodePageConfigurator extends PageConfigurator
{

    private static final long serialVersionUID = 1L;

    public DynamicSourceCodePageConfigurator()
    {

    }

    @Override
    public Page configure(Page page)
    {
        return page;
    }
}
