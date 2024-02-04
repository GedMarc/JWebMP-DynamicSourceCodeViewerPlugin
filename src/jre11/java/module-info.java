import com.jwebmp.plugins.dynamicsourcecode.implementations.DynamicSourceCodeInclusionModule;

module com.jwebmp.plugins.dynamicsourcecode {
	exports com.jwebmp.plugins.dynamicsourcecode;

	requires com.jwebmp.core;
	

	requires jakarta.validation;
	requires com.guicedee.guicedservlets;
	requires java.logging;
	requires com.jwebmp.plugins.google.sourceprettify;
	requires com.guicedee.guicedinjection;

	provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.dynamicsourcecode.DynamicSourceCodePageConfigurator;

	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions with com.jwebmp.plugins.dynamicsourcecode.implementations.DynamicSourceCodeExclusionsModule;
	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions with DynamicSourceCodeInclusionModule;
	
	opens com.jwebmp.plugins.dynamicsourcecode to com.fasterxml.jackson.databind, com.jwebmp.core;
}
