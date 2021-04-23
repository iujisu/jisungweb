package com.jisungweb.relationships;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "com.jisungweb.relationships"})
//@MapperScan(basePackages = {"com.jisungweb.relationships.member.mapper"})
@SpringBootApplication
public class JisungwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(JisungwebApplication.class, args);
	}

}
