package com.mfw.pages;

import org.openqa.selenium.By;
import static com.mfw.utils.PageActionsHelper.*;

public class LoginPage {
	
	private static final By USER_NAME_TEXT_BOX = By.id("txtUsername");
	private static final By PASSWORD_TEXT_BOX = By.id("txtPassword");
	private static final By LOGIN_BUTTON = By.id("btnLogin");
	
	private LoginPage setUsernameTextBox(String userName) {
		waitAndSendKeys(USER_NAME_TEXT_BOX, userName);
		return this;
		
	}
	
	private LoginPage setPaswordTextBox(String password) {
		waitAndSendKeys(PASSWORD_TEXT_BOX, password);
		return this;
		
	}
	
	private HomePage setLoginButton() {
		waitAndClick(LOGIN_BUTTON);
		return new HomePage();
	}
	
	public HomePage loginToApplication(String userName, String password) {
		return setUsernameTextBox(userName)
		.setPaswordTextBox(password)
		.setLoginButton();
	}
}
