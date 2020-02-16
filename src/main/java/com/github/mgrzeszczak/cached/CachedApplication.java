package com.github.mgrzeszczak.cached;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CachedApplication {

	public static void main(String[] args) {
		SpringApplication.run(CachedApplication.class, args);
	}

}
