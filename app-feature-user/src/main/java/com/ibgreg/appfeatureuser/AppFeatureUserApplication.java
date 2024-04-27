package com.ibgreg.appfeatureuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AppFeatureUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppFeatureUserApplication.class, args);
	}

}
