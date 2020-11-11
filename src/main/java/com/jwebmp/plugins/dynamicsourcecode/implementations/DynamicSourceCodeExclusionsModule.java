package com.jwebmp.plugins.dynamicsourcecode.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions;

import jakarta.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class DynamicSourceCodeExclusionsModule
		implements IGuiceScanModuleExclusions<DynamicSourceCodeExclusionsModule>
{

	@Override
	public @NotNull Set<String> excludeModules()
	{
		Set<String> strings = new HashSet<>();
		strings.add("com.jwebmp.plugins.dynamicsourcecode");
		return strings;
	}
}
