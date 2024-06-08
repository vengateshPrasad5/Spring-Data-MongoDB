package com.taskx.Spring.Data.MongoDB;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "Employee Management", version = "v1.1",
				description = "CRUD Operations of Employee using MongoDB")
)
public class SpringDataMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataMongoDbApplication.class, args);
	}

}
