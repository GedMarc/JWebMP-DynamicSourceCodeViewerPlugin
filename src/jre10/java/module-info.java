import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.plugins.dynamicsourcecode.DynamicSourceCodePageConfigurator;

module com.jwebmp.plugins.dynamicsourcecode {
	exports com.jwebmp.plugins.dynamicsourcecode;

	requires com.jwebmp.core;
	requires com.jwebmp.logmaster;
	requires com.fasterxml.jackson.annotation;

	requires java.validation;
	requires com.jwebmp.guicedservlets;
	requires java.logging;
	requires com.jwebmp.plugins.google.sourceprettify;

	provides IPageConfigurator with DynamicSourceCodePageConfigurator;
	opens com.jwebmp.plugins.dynamicsourcecode to com.fasterxml.jackson.databind,com.jwebmp.core;
}
