package com.ibm.controller.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.ibm.exception.TodoNotFoundException;

@RestControllerAdvice
public class TodoControllerAdvice {

	@ExceptionHandler(TodoNotFoundException.class)
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Todo Not Found!", code = HttpStatus.NOT_FOUND )
	public ResponseEntity<ErrorResponse> handleTodoNotFound(TodoNotFoundException e){
		ErrorResponse response = new ErrorResponse("TODO-404", new Date(), "Todo not found!");
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
}
