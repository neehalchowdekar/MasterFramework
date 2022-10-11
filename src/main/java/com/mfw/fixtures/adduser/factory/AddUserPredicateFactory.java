package com.mfw.fixtures.adduser.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;

import com.google.common.base.Supplier;
import com.mfw.fixtures.adduser.entity.UserData;
import com.mfw.pages.pagecomponents.adduserpage.AddUserComponent;

public class AddUserPredicateFactory {
	
	private static final Map<String, Supplier<BiPredicate<UserData, AddUserComponent>>> MAP = new HashMap<>();
	
	
	private static final BiPredicate<UserData, AddUserComponent> JUST_EMPLOYEE_NAME_PREDICATE = 
		(userData, addComponent) -> {
		addComponent
		.setEmployeeTextBox(userData.getEmployeeName());
		return addComponent.isErrorMessageDisplayed();
		};
		
	private static final BiPredicate<UserData, AddUserComponent> VALID_PREDICATE = 
		(userData, addComponent) -> {
		addComponent
		.setUserRoleDropDown(userData.getUserRole())
		.setEmployeeTextBox(userData.getEmployeeName())
		.setUserName(userData.getUserName())
		.setStatusDropDown(userData.getStatus())
		.setPasswordTextBox(userData.getPassword())
		.setConfirmPasswordTextBox(userData.getPassword());
		return addComponent.isSuccessMessageDisplayed();
			};
			
	static {
		MAP.put("valid", () -> VALID_PREDICATE);
		MAP.put("just_employeename", () -> JUST_EMPLOYEE_NAME_PREDICATE);
	}
	
	public static BiPredicate<UserData, AddUserComponent> getPredicate(String value){
		return MAP.get(value).get();
	}

}
