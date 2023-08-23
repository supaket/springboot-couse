package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

//		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
//
////		String[] beans = context.getBeanDefinitionNames();
////		for (String bean : beans) {
////			out.println(bean);
////		}
//////
////		int beanCount = context.getBeanDefinitionCount();
////		out.println(beanCount);
//
//		MainComponent main = context.getBean(MainComponent.class);
//		main.sayHelloFunction();
	}

}
