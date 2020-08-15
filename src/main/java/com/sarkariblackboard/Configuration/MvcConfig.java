package com.sarkariblackboard.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/403").setViewName("403");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(
				"/webjars/**",
				"/img/**",
				"/css/**",
				"/plugins/**",
				"/js/**")
				.addResourceLocations(
						"classpath:/META-INF/resources/webjars/",
						"classpath:/static/img/",
						"classpath:/static/css/",
						"classpath:/static/plugins/",
						"classpath:/static/js/");
	}

}
