package dev.emrx.gratitude.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringDocConfig {
  @Bean
  public OpenAPI customOpenAPI() {
      return new OpenAPI()
              .info(new Info()
                      .title("Gratitude Message API")
                      .description("API RESTful en Spring para enviar, almacenar y listar mensajes de agradecimientos. " +
                              "La API permitir a los usuarios compartan mensajes de agradecimiento.\n")
                      .contact(new Contact()
                              .name("Equipo de desarrollo")
                              .email("support@gratitude.com"))
                      .license(new License()
                              .name("Apache 2.0")
                              .url("http://gratitude.com/api/licencia"))
                      .version("1.0.0")
              );
  }
}
