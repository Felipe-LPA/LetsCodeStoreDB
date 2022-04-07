package com.letscode.store;

import com.letscode.store.model.Authority;
import com.letscode.store.model.AuthorityKey;
import com.letscode.store.model.User;
import com.letscode.store.repository.AuthorityRepository;
import com.letscode.store.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);

	}

	@Bean
	public CommandLineRunner test(UserRepository userRepository,
								  AuthorityRepository authorityRepository) {
		return (args) -> {

			User user = new User();
			user.setUserName("admin");
			user.setPassword("{bcrypt}" + new BCryptPasswordEncoder().encode("admin"));
			user.setEnabled(true);

			userRepository.save(user);

			Authority authority = new Authority();
			authority.setAuthorityKey(new AuthorityKey(user.getUserName(), "ROLE_ADMIN"));
			authority.setUser(user);

			authorityRepository.save(authority);

			authority = new Authority();

			authority.setAuthorityKey(new AuthorityKey(user.getUserName(), "ROLE_DEVELOPER"));
			authority.setUser(user);
			authorityRepository.save(authority);



		};
	}

}
