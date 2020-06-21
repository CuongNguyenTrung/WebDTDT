package com.c2code.realproject.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.context.annotation.Configuration;


public class SiteMeshConfig extends ConfigurableSiteMeshFilter {

	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		// TODO Auto-generated method stub
		builder.addDecoratorPath("/admin/*", "/WEB-INF/decorators/admin.jsp")
		.addDecoratorPath("/dtdd", "/WEB-INF/decorators/dtdd.jsp")
		.addDecoratorPath("/timkiem", "/WEB-INF/decorators/dtdd.jsp")
		.addDecoratorPath("/dtdd/*", "/WEB-INF/decorators/dtdd.jsp")
		.addDecoratorPath("/gio-hang", "/WEB-INF/decorators/dtdd.jsp");
		
	}
}
