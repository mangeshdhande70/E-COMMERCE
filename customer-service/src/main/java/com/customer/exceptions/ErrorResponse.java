package com.customer.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ErrorResponse {
	
	private int statusCode;
	private String message;
	private String description;
	private Date timestamp;

}
