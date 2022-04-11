package com.example.service1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class Service1Application {

	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}

	// TODO
	// 1. define a GET endpoint /api/greeting which should accept a query parameter "name"
	// 2. return should be a string returning a greeting: Hello Brasov
	// 3. print request headers
	// 4. register the service in eureka

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/api/greeting")
	public String greeting(@RequestHeader HttpHeaders headers, String name){
		for(String headerKey : headers.keySet()){
			System.out.println(headerKey + ": " + headers.get(headerKey));
		}

		return "Hello Brasov";
	}

}
