package com.ibgreg.appfeaturetoggle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AppFeatureToggleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppFeatureToggleApplication.class, args);
	}

}
