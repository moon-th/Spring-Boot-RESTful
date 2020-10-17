package com.example.restfulwebservice.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Http Status code
// 2XX -> Ok
// 4XX -> Client
// 5XX -> Server
@ResponseStatus(HttpStatus.NOT_FOUND) //4XX 오류를 반환 해 준다.
public class UserNotFoundEXception extends RuntimeException{

	public UserNotFoundEXception(String message) {
		super(message);
	}
}
