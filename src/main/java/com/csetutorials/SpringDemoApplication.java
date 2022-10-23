package com.csetutorials;

import com.google.gson.Gson;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@Bean
	public JPAQueryFactory getQueryFactory(EntityManager em) {
		return new JPAQueryFactory(em);
	}

}
