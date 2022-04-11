package com.example.service2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class Service2Application {
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	static
	class Product{
		private String name;
		private Integer quantity;
	}

	public static List<Product> productList = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(Service2Application.class, args);
	}
	// TODO
	// 1. define a POST endpoint /product which should accept a request body containing two properties -product name and quantity
	//2. save the request body in memory
	// 3. return 200 if OK
	// 4. print request headers
	// 5. register the service in eureka
	// 6. define a GET endpoint /product to return the saved data using the POST endpoint - return type is List<Product>

	@PostMapping("/product")
	@ResponseStatus(HttpStatus.OK)
	public Product saveProduct(@RequestHeader HttpHeaders headers, @RequestBody Product product){
		for(String headerKey : headers.keySet()){
			System.out.println(headerKey + ": " + headers.get(headerKey));
		}

		Service2Application.productList.add(product);
		return product;
	}

	@GetMapping("/product")
	public List<Product> getProductList(){
		return Service2Application.productList;
	}
}
