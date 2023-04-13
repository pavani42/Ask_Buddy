package com.hcl.ask_buddy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = IdNotFoundException.class)
	@ResponseBody
	public ErrorResponse handleNotFoundException(IdNotFoundException idException) {

		ErrorResponse response = new ErrorResponse();
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		response.setMessage(idException.getMessage());
		return response;
	}

}
