package org.openapitools;

import com.fasterxml.jackson.databind.Module;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(
    nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
@ComponentScan(
    basePackages = {
        "org.openapitools",
        "com.speed_liv.menu.api",
        "com.speed_liv.menu.service",
        "com.speed_liv.menu.model.repository",
        "com.speed_liv.menu.infrastructure.json",
        "com.speed_liv.menu.infrastructure.jpa",   // ✅ ajouté
        "org.openapitools.configuration"
    },
    nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
@EnableJpaRepositories(basePackages = "com.speed_liv.menu.infrastructure.jpa") // ✅ corrigé
@EntityScan(basePackages = "com.speed_liv.menu.model.entity")
public class OpenApiGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenApiGeneratorApplication.class, args);
    }

    @Bean(name = "org.openapitools.OpenApiGeneratorApplication.jsonNullableModule")
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }
}
