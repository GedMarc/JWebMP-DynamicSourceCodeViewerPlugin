import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanJarExclusions;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanModuleExclusions;
import com.jwebmp.plugins.dynamicsourcecode.DynamicSourceCodePageConfigurator;
import com.jwebmp.plugins.dynamicsourcecode.implementations.DynamicSourceCodeExclusionsModule;

module com.jwebmp.plugins.dynamicsourcecode {
	exports com.jwebmp.plugins.dynamicsourcecode;

	requires com.jwebmp.core;
	requires com.jwebmp.logmaster;
	requires com.fasterxml.jackson.annotation;

	requires java.validation;
	requires com.jwebmp.guicedservlets;
	requires java.logging;
	requires com.jwebmp.plugins.google.sourceprettify;
	requires com.jwebmp.guicedinjection;

	provides IPageConfigurator with DynamicSourceCodePageConfigurator;

	provides IGuiceScanJarExclusions with DynamicSourceCodeExclusionsModule;
	provides IGuiceScanModuleExclusions with DynamicSourceCodeExclusionsModule;


	opens com.jwebmp.plugins.dynamicsourcecode to com.fasterxml.jackson.databind, com.jwebmp.core;
}
