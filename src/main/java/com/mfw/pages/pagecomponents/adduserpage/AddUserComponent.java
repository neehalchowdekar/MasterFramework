package com.mfw.pages.pagecomponents.adduserpage;

import java.util.function.BiPredicate;

import org.openqa.selenium.By;

import com.mfw.fixtures.adduser.entity.UserData;
import com.mfw.utils.PageActionsHelper;

public class AddUserComponent {
	
	private static final By USER_ROLE_DROP_DOWN = By.xpath("//label[text()='User Role']/following-sibling::select");
	private static final By EMPLOYEE_TEXT_BOX = By.xpath("//label[text()='Employee Name']/following-sibling::input");
	private static final By USERNAME_TEXT_BOX = By.xpath("//label[text()='Username']/following-sibling::input");
	private static final By STATUS_DROP_BOX = By.xpath("//label[text()='Status']/following-sibling::select");
	private static final By PASSWORD_TEXT_BOX = By.xpath("//label[text()='Password']/following-sibling::input");
	private static final By COMFIRM_PASSWORD_TEXT_BOX = By.xpath("//label[text()='Confirm Password']/following-sibling::input");
	private static final By ERROR_MESSAGE_FOR_EMPLOYEE_NAME = By.xpath("//span[@for='systemUser_employeeName_empName']");
	
	public AddUserComponent setUserRoleDropDown(String userRole) {
		PageActionsHelper.select(USER_ROLE_DROP_DOWN, e -> e.selectByVisibleText(userRole));
		return this;
	}
	
	public AddUserComponent setEmployeeTextBox(String employeeName) {
		PageActionsHelper.waitAndSendKeys(EMPLOYEE_TEXT_BOX, employeeName);
		return this;
	}
	
	public AddUserComponent setUserName(String username) {
		PageActionsHelper.waitAndSendKeys(USERNAME_TEXT_BOX, username);
		return this;
	}
	
	public AddUserComponent setStatusDropDown(String status) {
		PageActionsHelper.select(STATUS_DROP_BOX, e -> e.selectByVisibleText(status));
		return this;
	}
	
	public AddUserComponent setPasswordTextBox(String password) {
		PageActionsHelper.waitAndSendKeys(PASSWORD_TEXT_BOX, password);
		return this;
	}
	
	public AddUserComponent setConfirmPasswordTextBox(String confirmPassword) {
		PageActionsHelper.waitAndSendKeys(COMFIRM_PASSWORD_TEXT_BOX, confirmPassword);
		return this;
	}
	
	public boolean fillDetails(UserData userData, BiPredicate<UserData, AddUserComponent> predicate) {
//		setUserRoleDropDown(userData.getUserRole())
//		.setEmployeeTextBox(userData.getEmployeeName())
//		.setUserName(userData.getUserName())
//		.setStatusDropDown(userData.getStatus())
//		.setPasswordTextBox(userData.getPassword())
//		.setConfirmPasswordTextBox(userData.getPassword());
		return predicate.test(userData, this);
	}
	
	public boolean isErrorMessageDisplayed() {
		return PageActionsHelper.getText(ERROR_MESSAGE_FOR_EMPLOYEE_NAME)
				.equalsIgnoreCase("Employee does not exist");
	}
	
	public boolean isSuccessMessageDisplayed() {
		return true;
	}

}
