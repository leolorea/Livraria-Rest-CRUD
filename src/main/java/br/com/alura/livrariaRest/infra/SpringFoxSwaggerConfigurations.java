package br.com.alura.livrariaRest.infra;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SpringFoxSwaggerConfigurations extends WebMvcConfigurerAdapter {
	
	
	@Bean
	
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build().globalRequestParameters
							(Arrays.asList(
							new RequestParameterBuilder()
							.name("Authorization")
							.description("Bearer token")
							.required(false)
							.in("header")
							.build()));
				
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
	      .addResourceLocations("classpath:/META-INF/resources/");

	    registry.addResourceHandler("/webjars/**")
	      .addResourceLocations("classpath:/META-INF/resources/webjars/");
		
	}
	 
	

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Livraria Api Rest CRUD").description("sistema para a livaria Pipoca")
				.termsOfServiceUrl("https://simplifyingtech371899608.wordpress.com/")
				.licenseUrl("simplifyingtech@gmail.com").version("2.0").build();
	}
}
