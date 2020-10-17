package com.example.restfulwebservice.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.restfulwebservice.user.UserNotFoundEXception;

@RestController
@ControllerAdvice //모든 컨트롤러가 실행이 될때 사전에 실행이 되어 에러가 발생시 설정된 에러 메세지가 호출된다.
public class CustomizedResponseExtityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
		
		ExceptionResponse exceptionResponse = 
					new ExceptionResponse (new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(exceptionResponse , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundEXception.class)
	public final ResponseEntity<Object> handleUserNotFoundExceptions(Exception ex, WebRequest request){
		
		ExceptionResponse exceptionResponse = 
					new ExceptionResponse (new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(exceptionResponse , HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), 
				ex.getMessage(),ex.getBindingResult().toString());
		
				
	return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
