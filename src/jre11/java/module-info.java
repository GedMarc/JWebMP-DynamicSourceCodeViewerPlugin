module com.jwebmp.plugins.dynamicsourcecode {
	exports com.jwebmp.plugins.dynamicsourcecode;

	requires com.jwebmp.core;
	requires com.guicedee.logmaster;

	requires java.validation;
	requires com.guicedee.guicedservlets;
	requires java.logging;
	requires com.jwebmp.plugins.google.sourceprettify;
	requires com.guicedee.guicedinjection;

	provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.dynamicsourcecode.DynamicSourceCodePageConfigurator;

	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions with com.jwebmp.plugins.dynamicsourcecode.implementations.DynamicSourceCodeExclusionsModule;

	opens com.jwebmp.plugins.dynamicsourcecode to com.fasterxml.jackson.databind, com.jwebmp.core;
}
