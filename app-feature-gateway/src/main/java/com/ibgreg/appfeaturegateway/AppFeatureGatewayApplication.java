package com.ibgreg.appfeaturegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AppFeatureGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppFeatureGatewayApplication.class, args);
	}

}
