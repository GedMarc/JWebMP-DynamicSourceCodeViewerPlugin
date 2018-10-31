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

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Options for the dynamic source code guy
 * <p>
 *
 * @author GedMarc
 * @version 1.0
 * 		<p>
 * 		<p>
 * @since Nov 11, 2016
 */
public class DynamicSourceCodeOptions<J extends DynamicSourceCodeOptions<J>>
		extends JavaScriptPart<J>
{


	/**
	 * The source url for the code
	 */
	private String srcUrl;
	/**
	 * The default theme applied
	 */
	private String defaultTheme;
	/**
	 * The class name for pretty print
	 */
	private String prettyPrintClass;
	/**
	 * The file extension
	 */
	private String fileExtension;

	/**
	 * The list of options
	 */
	public DynamicSourceCodeOptions()
	{
		//Nothing Needed
	}

	/**
	 * Sets the URL that is the base of the class hierarchy
	 *
	 * @return
	 */
	public String getSrcUrl()
	{
		return srcUrl;
	}

	/**
	 * Sets the URL that is the base of the class hierarchy
	 *
	 * @param srcUrl
	 */
	public void setSrcUrl(String srcUrl)
	{
		this.srcUrl = srcUrl;
	}

	/**
	 * Gets the default theme applied
	 *
	 * @return
	 */
	public String getDefaultTheme()
	{
		return defaultTheme;
	}

	/**
	 * Sets the default theme applied
	 *
	 * @param defaultTheme
	 */
	public void setDefaultTheme(String defaultTheme)
	{
		this.defaultTheme = defaultTheme;
	}

	/**
	 * Gets the pretty print class
	 *
	 * @return
	 */
	public String getPrettyPrintClass()
	{
		return prettyPrintClass;
	}

	/**
	 * Sets the pretty print class
	 *
	 * @param prettyPrintClass
	 */
	public void setPrettyPrintClass(String prettyPrintClass)
	{
		this.prettyPrintClass = prettyPrintClass;
	}

	/**
	 * The file extension
	 *
	 * @return
	 */
	public String getFileExtension()
	{
		return fileExtension;
	}

	/**
	 * The source file extension
	 *
	 * @param fileExtension
	 */
	public void setFileExtension(String fileExtension)
	{
		this.fileExtension = fileExtension;
	}

}
