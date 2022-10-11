package com.mfw.fixtures.adduser.entity;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
public class LoginData {
	
	private String userName;
	private String password;
	private String message;

}
