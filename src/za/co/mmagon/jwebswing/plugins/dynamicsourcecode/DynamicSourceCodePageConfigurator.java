/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
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
@PluginInformation(pluginName = "Dynamic Source Code Viewer", pluginUniqueName = "jw-source-code-viewer",
        pluginDescription = "Provides a source code viewer that can load and display source from pretty much anywhere",
        pluginVersion = "1.0.0",
        pluginDependancyUniqueIDs = "jquery,google-code-prettify",
        pluginCategories = "jquery, ui, source display, web, framework",
        pluginSubtitle = "A basic screen with buttons to load sources, a format drop down, and a source display screen",
        pluginGitUrl = "https://github.com/GedMarc/JWebSwing-DynamicSourceCodeViewerPlugin",
        pluginSourceUrl = "http://www.jqwidgets.com/",
        pluginWikiUrl = "https://github.com/GedMarc/JWebSwing-DynamicSourceCodeViewerPlugin/wiki",
        pluginOriginalHomepage = "http://www.jwebswing.com/",
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
