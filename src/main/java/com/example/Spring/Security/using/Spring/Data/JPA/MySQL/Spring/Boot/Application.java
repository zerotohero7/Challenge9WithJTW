package com.example.Spring.Security.using.Spring.Data.JPA.MySQL.Spring.Boot;

import com.example.Spring.Security.using.Spring.Data.JPA.MySQL.Spring.Boot.Repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
