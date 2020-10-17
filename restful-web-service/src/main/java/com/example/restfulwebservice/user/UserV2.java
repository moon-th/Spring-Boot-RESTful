package com.example.restfulwebservice.user;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@JsonFilter("UserInfoV2")
@NoArgsConstructor
public class UserV2 extends User{
	private String grade;
	
	
	
}
