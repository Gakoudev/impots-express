package com.isiexam;

import com.isiexam.mapping.DeclarantMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ImpotsExpressApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImpotsExpressApplication.class, args);
	}


}
