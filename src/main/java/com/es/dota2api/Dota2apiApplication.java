package com.es.dota2api;

import com.es.dota2api.security.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class Dota2apiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Dota2apiApplication.class, args);
	}

}
