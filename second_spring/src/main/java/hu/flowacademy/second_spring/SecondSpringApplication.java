package hu.flowacademy.second_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class SecondSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondSpringApplication.class, args);
	}

}
