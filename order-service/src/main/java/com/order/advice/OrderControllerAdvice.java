package com.order.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.order.exception.BusinessException;
import com.order.exception.ErrorResponse;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class OrderControllerAdvice {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorResponse> handle(EntityNotFoundException e, WebRequest request) {
		ErrorResponse errorResponse = ErrorResponse.builder().message(e.getMessage())
				.description(request.getDescription(false)).statusCode(HttpStatus.BAD_REQUEST.value())
				.timestamp(new Date()).build();

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e,
			WebRequest request) {

		ErrorResponse errorResponse = ErrorResponse.builder().message(e.getMessage())
				.description(request.getDescription(false)).statusCode(HttpStatus.BAD_REQUEST.value())
				.timestamp(new Date()).build();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ErrorResponse> handle(BusinessException e, WebRequest request) {
		ErrorResponse errorResponse = ErrorResponse.builder().message(e.getMessage())
				.description(request.getDescription(false)).statusCode(HttpStatus.BAD_REQUEST.value())
				.timestamp(new Date()).build();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

}
