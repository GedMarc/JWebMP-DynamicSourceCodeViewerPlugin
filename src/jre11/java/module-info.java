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

	provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.dynamicsourcecode.DynamicSourceCodePageConfigurator;

	provides com.jwebmp.guicedinjection.interfaces.IGuiceScanJarExclusions with com.jwebmp.plugins.dynamicsourcecode.implementations.DynamicSourceCodeExclusionsModule;
	provides com.jwebmp.guicedinjection.interfaces.IGuiceScanModuleExclusions with com.jwebmp.plugins.dynamicsourcecode.implementations.DynamicSourceCodeExclusionsModule;


	opens com.jwebmp.plugins.dynamicsourcecode to com.fasterxml.jackson.databind, com.jwebmp.core;
}
