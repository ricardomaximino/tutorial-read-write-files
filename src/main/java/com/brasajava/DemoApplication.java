package com.brasajava;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.brasajava.service.ReadFileService;
import com.brasajava.service.WriteFileService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner(WriteFileService writeService, ReadFileService readService) {
		return (args)-> {
			writeService.writeOnTheFileWithFormater();
			writeService.writeOnTheFile();
			readService.readTheFileWithScanner();
			readService.readTheFile();
		};
	}
}
