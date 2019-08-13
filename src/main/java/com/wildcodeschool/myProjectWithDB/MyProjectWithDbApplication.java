package com.wildcodeschool.myProjectWithDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class MyProjectWithDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProjectWithDbApplication.class, args);
	}

}
