package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class DemoApplication {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplateBuilder().build();
	}

	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);

		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		String[] beans = context.getBeanDefinitionNames();
		System.out.println("-------BEAN NAMES------");
		for (String bean : beans) {
			System.out.println(bean);
		}
		System.out.println("-------------");

		int beanCount = context.getBeanDefinitionCount();
		System.out.println(beanCount);

		MainComponent2 main = context.getBean(MainComponent2.class);
		main.sayHelloFunction();
	}

}
