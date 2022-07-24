package com.mfw.pages.pagecomponents.adduserpage;

import org.openqa.selenium.By;

import com.mfw.utils.PageActionsHelper;

public class UserListComponent {

	private static final By ADD_BUTTON = By.id("btnAdd");
	
	
	public AddUserComponent setAddButton() {
		PageActionsHelper.waitAndClick(ADD_BUTTON);
		return new AddUserComponent();
	}
}
