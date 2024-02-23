package com.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.model.ErrorData;

@RestControllerAdvice
public class StudentExceptionHandler  {

//	@ExceptionHandler(StudentNotFoundException.class)
//	public ResponseEntity<String> ExceptionMethod1(StudentNotFoundException ee){
//		return new ResponseEntity<String>(ee.getMessage(),HttpStatus.NOT_FOUND);
//	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorData> ExceptionMethod1(StudentNotFoundException ee){
		return new ResponseEntity<ErrorData>(new ErrorData(
				ee.getMessage(),
				new Date().toString(),
				"Student"),HttpStatus.NOT_FOUND);
	}
}
