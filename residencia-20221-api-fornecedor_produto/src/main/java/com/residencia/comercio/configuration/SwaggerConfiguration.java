package com.residencia.comercio.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;

@Configuration
public class SwaggerConfiguration {
	
	@Bean
	public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
		return new OpenAPI()
				.components(new Components()
						.addParameters("myHeader1",
								new Parameter().in("header").schema(new StringSchema()).name("myHeader1"))
						.addHeaders("myHeader2",
								new Header().description("myHeader2 header").schema(new StringSchema())))
				.info(new Info().title("API Comércio Grupo 7").version(appVersion).description(
						"Trabalho para matéria de Desenvolvimento de API Restful."));

	}
}
