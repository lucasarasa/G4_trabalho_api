package br.com.trabalhofinal.grupoquatro.configs;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
@SecurityScheme(name="Bearer Auth", type=SecuritySchemeType.HTTP, scheme="bearer", bearerFormat="JWT")
public class SwaggerConfig {
	
	@Value("${prop.swagger.dev-url}")
	private String devUrl;
	
	@Bean
	public OpenAPI myOpenAPI() {
		Server server = new Server();
		server.setUrl(devUrl);
		server.setDescription("Development Server");
		
		Contact contact = new Contact();
		contact.setEmail("apirestgrupo4@gmail.com");
		contact.setName("Grupo 4");
		contact.setUrl("grupo4.net");
		
		License license = new License();
		license.setName("Apache License 2.0");
		license.setUrl("https://www.apache.org/licenses/LICENSE-2.0.html");
		
		Info info = new Info();
		info.setTitle("Grupo 4");
		info.setVersion("25.12.2");
		info.setDescription("API Grupo 4");
		info.setContact(contact);
		info.setLicense(license);
		info.setTermsOfService("https://swagger.io/terms/");
		
		return new OpenAPI().info(info).servers(List.of(server));
		
	}

}

