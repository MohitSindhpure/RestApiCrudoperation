package com.BikkadIT.RestApiCrudoperation.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.BikkadIT.RestApiCrudoperation"))
				.paths(PathSelectors.any()).build();

	}

	private ApiInfo getInfo() {

		return new ApiInfo("Mohit Swagger", "This project is devloped by Shruteekatech Company", "version 1.0", "pune", "ShruteekaTech", "mohitsindhpure1998@gmail.com", "NextPage Name");	
	}

}
