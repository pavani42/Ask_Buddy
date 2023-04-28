package com.hcl.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.config.GlobalCorsProperties;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class GatewayApplication {

//	@Value("${http.request.headers.authorization}")
//	private static String jwttoken;
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
//	@Bean
//	public GlobalCorsProperties globalCorsProperties() {
//	    return new GlobalCorsProperties();
//	}

}
