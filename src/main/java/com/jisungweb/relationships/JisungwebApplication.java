package com.jisungweb.relationships;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "com.jisungweb.relationships"})
/*
 * @EnableConfigurationProperties( {FileUploadProperties.class} )
 */
@SpringBootApplication
public class JisungwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(JisungwebApplication.class, args);
	}

}
