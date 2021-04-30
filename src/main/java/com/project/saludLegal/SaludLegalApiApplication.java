package com.project.saludLegal;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.project.saludLegal.controllers.ExceptionGlobalResponse;
import com.project.saludLegal.repositories.AgendaJDBCRepository;

@SpringBootApplication
//@Import(ExceptionGlobalResponse.class)
public class SaludLegalApiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SaludLegalApiApplication.class, args);
		
	}
	
}
