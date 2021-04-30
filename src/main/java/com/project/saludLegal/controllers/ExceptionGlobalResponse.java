package com.project.saludLegal.controllers;


import java.util.HashMap;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;	
import org.springframework.web.bind.annotation.ControllerAdvice;	
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.saludLegal.exceptions.AppointmentAlreadyExistsException;
import com.project.saludLegal.exceptions.BadValueException;
import com.project.saludLegal.exceptions.CantAppointException;
import com.project.saludLegal.exceptions.DiaryAlreadyExistsException;
import com.project.saludLegal.exceptions.SintomaAlreadyExistsException;

import javassist.NotFoundException;	

@RestControllerAdvice	
public class ExceptionGlobalResponse{	
	
	@ExceptionHandler(value = {RuntimeException.class}) 
	public ResponseEntity<?> runtimeException(RuntimeException e) {			
		HashMap<String, String> result = new HashMap<String,String>();
		result.put("Error", e.getMessage());
		return new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
	@ExceptionHandler(value = {BadRequest.class}) 
	public ResponseEntity<?> badRequestException(BadRequest e) {			
		HashMap<String, String> result = new HashMap<String,String>();
		result.put("Error", e.getMessage());
		return new ResponseEntity(result, HttpStatus.BAD_REQUEST);		
	}
	
	@ExceptionHandler(value = {BadValueException.class}) 
	public ResponseEntity<?> badValueException(BadValueException e) {			
		HashMap<String, String> result = new HashMap<String,String>();
		result.put("Error", e.getMessage());
		return new ResponseEntity(result, HttpStatus.BAD_REQUEST);		
	}
	
	
	@ExceptionHandler(value = {CantAppointException.class}) 
	public ResponseEntity<?> cantAppointException(CantAppointException e) {			
		HashMap<String, String> result = new HashMap<String,String>();
		result.put("Error", e.getMessage());
		return new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
	@ExceptionHandler(value = {Error.class}) 
	public ResponseEntity<?> generalException(Error e) {			
		HashMap<String, String> result = new HashMap<String,String>();
		result.put("Error", e.getMessage());
		return new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
	@ExceptionHandler(value = {DataAccessException.class}) 
	public ResponseEntity<?> dataBaseException(DataAccessException e) {			
		HashMap<String, String> result = new HashMap<String,String>();
		result.put("Error", e.getMessage());
		return new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);		
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> notFoundExcepion(NotFoundException e) {			
		
		HashMap<String, String> result = new HashMap<String,String>();
		result.put("Error", e.getMessage());
		return new ResponseEntity(result, HttpStatus.NOT_FOUND);		
	}
	
	@ExceptionHandler(AppointmentAlreadyExistsException.class)
	public ResponseEntity<?> appointmentException(AppointmentAlreadyExistsException e) {			
		
		HashMap<String, String> result = new HashMap<String,String>();
		result.put("Error", e.getMessage());
		return new ResponseEntity(result, HttpStatus.CONFLICT);		
	}
	
	@ExceptionHandler(DiaryAlreadyExistsException.class)
	public ResponseEntity<?> agendaException(DiaryAlreadyExistsException e) {			
		HashMap<String, String> result = new HashMap<String,String>();
		result.put("Error", e.getMessage());
		return new ResponseEntity(result, HttpStatus.CONFLICT);		
	}
	
	@ExceptionHandler(SintomaAlreadyExistsException.class)
	public ResponseEntity<?> sintomaException(SintomaAlreadyExistsException e) {			
		HashMap<String, String> result = new HashMap<String,String>();
		result.put("Error", e.getMessage());
		return new ResponseEntity(result, HttpStatus.CONFLICT);		
	}
}



		