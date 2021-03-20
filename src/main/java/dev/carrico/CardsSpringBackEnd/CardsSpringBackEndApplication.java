package dev.carrico.CardsSpringBackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"dev.carrico"})
@EnableJpaRepositories(basePackages = {"dev.carrico.repos"})
@EntityScan(basePackages = {"dev.carrico.entities"})
@SpringBootApplication
public class CardsSpringBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsSpringBackEndApplication.class, args);
	}

}
