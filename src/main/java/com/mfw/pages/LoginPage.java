package com.mfw.pages;

import static com.mfw.utils.PageActionsHelper.getText;
import static com.mfw.utils.PageActionsHelper.waitAndClick;
import static com.mfw.utils.PageActionsHelper.waitAndSendKeys;
import java.util.concurrent.TimeUnit;
import java.util.function.BiPredicate;
import org.openqa.selenium.By;
import com.google.common.util.concurrent.Uninterruptibles;
import com.mfw.fixtures.adduser.entity.LoginData;

public class LoginPage {
	
	private static final By USER_NAME_TEXT_BOX = By.id("txtUsername");
	private static final By PASSWORD_TEXT_BOX = By.id("txtPassword");
	private static final By LOGIN_BUTTON = By.id("btnLogin");
	private static final By INVALID_CREDENTIALS_TEXT = By.id("spanMessage");
	
	public LoginPage setUsernameTextBox(String userName) {
		waitAndSendKeys(USER_NAME_TEXT_BOX, userName);
		return this;
		
	}
	
	public LoginPage setPaswordTextBox(String password) {
		waitAndSendKeys(PASSWORD_TEXT_BOX, password);
		return this;
		
	}
	
	public LoginPage setLoginButton() {
		waitAndClick(LOGIN_BUTTON);
		return this;
	}
	
	public String getInvalidCredentialsText() {
		return getText(INVALID_CREDENTIALS_TEXT);
	}
	
	public boolean isErrorMessageDisplayed(String value) {
		Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
		return getInvalidCredentialsText().equals(value);
	}
	
	public HomePage loginToApplication(String userName, String password) {
		 setUsernameTextBox(userName)
		.setPaswordTextBox(password)
		.setLoginButton();
		 return new HomePage();
	}
	
	public boolean loginDetails(LoginData loginData, BiPredicate<LoginData, LoginPage> predicate ) {
		return predicate.test(loginData, this);
	}
}
