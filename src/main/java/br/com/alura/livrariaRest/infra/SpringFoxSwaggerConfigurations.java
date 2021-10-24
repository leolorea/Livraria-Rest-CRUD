package br.com.alura.livrariaRest.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxSwaggerConfigurations {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Livraria Api Rest CRUD").description("sistema para a livaria Pipoca")
				.termsOfServiceUrl("https://simplifyingtech371899608.wordpress.com/")
				.licenseUrl("simplifyingtech@gmail.com").version("2.0").build();
	}
}
/*
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration;
 * 
 * import springfox.documentation.builders.PathSelectors; import
 * springfox.documentation.builders.RequestHandlerSelectors; import
 * springfox.documentation.spi.DocumentationType; import
 * springfox.documentation.spring.web.plugins.Docket; import
 * springfox.documentation.swagger2.annotations.EnableSwagger2;
 * 
 * @Configuration public class SpringFoxSwaggerConfigurations {
 * 
 * @Bean public Docket api() { return new Docket(DocumentationType.SWAGGER_2)
 * .select() .apis(RequestHandlerSelectors.any()) .paths(PathSelectors.any())
 * .build(); } }
 * 
 */