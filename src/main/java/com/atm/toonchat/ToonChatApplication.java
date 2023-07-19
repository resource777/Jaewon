package com.atm.toonchat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ToonChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToonChatApplication.class, args);
	}

}
