package com.example.Book.Microservice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
@EnableFeignClients
public class BookMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookMicroserviceApplication.class, args);
	}
	@Bean
	public OpenAPI customOpenAPI(@Value("hello swagger ") String appDesciption, @Value("testing api") String appVersion) {
		return new OpenAPI()
				.info(new Info()
						.title("sample application API")
						.version(appVersion)
						.description(appDesciption)
						.termsOfService("http://swagger.io/terms/")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}
}
