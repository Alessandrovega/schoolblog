package pe.edu.upc.schoolblog.shared.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenApi (
            @Value("${documentation.application.description}") String applicationDescription,
            @Value("${documentation.application.version}") String applicationVersion) {
        return new OpenAPI().info(new Info()
                .title("Schedule API")
                .version(applicationVersion)
                .description(applicationDescription)
                .contact(new Contact()
                        .url("https://www.upc.edu.pe")
                        .name("UPC-si729"))
        );
    }
}