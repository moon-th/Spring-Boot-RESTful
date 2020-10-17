package com.example.restfulwebservice.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@JsonFilter("UserInfo")
@NoArgsConstructor
public class User {
	
	private Integer id;
	@Size(min=2,message= "Name은 2글자 이상 입력해 주세요")
	private String name;
	@Past // 과거데이터만 사용 할 수 있다는 벨리데이션
	private Date joinDate;
	
	private String password;
	private String ssn;
	
	
	
}
