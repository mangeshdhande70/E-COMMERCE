package com.customer.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.customer.exceptions.CustomerNotFoundException;
import com.customer.exceptions.ErrorResponse;

@RestControllerAdvice
public class CustomerControllerAdvice {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponse> customerNotFoundExceptionHandler(CustomerNotFoundException exception,
			WebRequest request) {

		ErrorResponse errorResponse = ErrorResponse.builder().statusCode(HttpStatus.NOT_FOUND.value())
				.message(exception.getMessage()).description(request.getDescription(false)).timestamp(new Date())
				.build();

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> globalExceptionHandler(Exception exception, WebRequest request) {

		ErrorResponse errorResponse = ErrorResponse.builder().statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.message(exception.getMessage()).description(request.getDescription(false)).timestamp(new Date())
				.build();

		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
