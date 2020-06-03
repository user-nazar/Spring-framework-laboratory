package ua.lviv.iot.machinery.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "ua.lviv.iot.machinery.dataaccess", "ua.lviv.iot.machinery.business",
		"ua.lviv.iot.machinery.spring.controller" })
@EnableJpaRepositories({ "ua.lviv.iot.machinery.dataaccess" })
public class RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

}