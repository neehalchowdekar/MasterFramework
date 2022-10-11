package com.mfw.fixtures.adduser.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

import com.mfw.fixtures.adduser.entity.LoginData;
import com.mfw.pages.LoginPage;

public class LoginUserPredicateFactory {
	
	
	private static Map<String, Supplier<BiPredicate<LoginData, LoginPage>>> MAP = new HashMap<>();
	
	
	private static final BiPredicate<LoginData, LoginPage> VALID_USER = (loginData, loginPage) ->
	{
	return loginPage
	.loginToApplication(loginData.getUserName(), loginData.getPassword())
	.getTopMenuComponent()
	.isWelcomeTextDisplayed();
	};
	
	
	private static final BiPredicate<LoginData, LoginPage> IN_VALID_USER = (loginData, loginPage) ->
	{
	return loginPage
	.setUsernameTextBox(loginData.getUserName())
	.setPaswordTextBox(loginData.getPassword())
	.setLoginButton()
	.isErrorMessageDisplayed(loginData.getMessage());
	};
	
	
	private static final BiPredicate<LoginData, LoginPage> USER_NAME_EMPTY = (loginData, loginPage) ->
	{
	return loginPage
	.setUsernameTextBox(loginData.getUserName())
	.setLoginButton()
	.isErrorMessageDisplayed(loginData.getMessage());
	};
	
	private static final BiPredicate<LoginData, LoginPage> PASSWORD_EMPTY = (loginData, loginPage) ->
	{
	return loginPage
	.setPaswordTextBox(loginData.getPassword())
	.setLoginButton()
	.isErrorMessageDisplayed(loginData.getMessage());
	};
	
	
	static {
		MAP.put("valid", () -> VALID_USER);
		MAP.put("invalid", () -> IN_VALID_USER);
		MAP.put("username_empty", () -> USER_NAME_EMPTY);
		MAP.put("password_empty", () -> PASSWORD_EMPTY);
	}
	
	public static BiPredicate<LoginData, LoginPage> getPredicate(String value){
		return MAP.get(value).get();
	}
}
