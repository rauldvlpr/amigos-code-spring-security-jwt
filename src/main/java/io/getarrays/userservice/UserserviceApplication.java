package io.getarrays.userservice;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;
import io.getarrays.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Raul Castillo", "rauldvlpr", "welcome1", new ArrayList<>()));
			userService.saveUser(new User(null, "Alma Rico", "almarich", "welcome1", new ArrayList<>()));
			userService.saveUser(new User(null, "Renata Castillo", "renatacr", "welcome1", new ArrayList<>()));


			userService.addRoleToUser("rauldvlpr", "ROLE_ADMIN");
			userService.addRoleToUser("almarich", "ROLE_MANGER");
			userService.addRoleToUser("renatacr", "ROLE_USER");
		};
	}

}
