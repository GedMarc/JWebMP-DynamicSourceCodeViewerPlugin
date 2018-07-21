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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jwebmp.plugins.dynamicsourcecode;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.plugins.google.sourceprettify.SourceCodePrettifyThemes;
import org.junit.jupiter.api.Test;

/**
 * @author GedMarc
 */
public class DynamicSourceCodeTest
{

	public DynamicSourceCodeTest()
	{
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testDefaultOutput()
	{
		Page p = new Page();
		p.getOptions()
		 .setDynamicRender(false);
		DynamicSourceCode dsc = new DynamicSourceCode();
		p.getBody()
		 .add(dsc);

		Div themeChange = new Div();
		dsc.addThemeChanger(themeChange, SourceCodePrettifyThemes.Desert);
		p.getBody()
		 .add(themeChange);

		Div srcChange = new Div();
		dsc.addSourceChanger(srcChange, DynamicSourceCode.class);
		p.getBody()
		 .add(srcChange);

		System.out.println(p.toString(true));
	}
}
