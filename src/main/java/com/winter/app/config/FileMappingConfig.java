package com.winter.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//***-context.xml과 같은 역할
@Configuration
public class FileMappingConfig implements WebMvcConfigurer {
	
	//local file 위치
	@Value("${app.upload.mapping}")
	private String filePath;
	
	//요청 url 경로
	@Value("${app.url.path}")
	private String urlPath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//요청url
		registry.addResourceHandler(urlPath);
		//local file 위치
//		registry.addResourceLocations(filePath);
		
	}
	
}
