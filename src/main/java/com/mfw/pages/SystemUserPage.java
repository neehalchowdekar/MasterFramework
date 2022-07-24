package com.mfw.pages;

import com.mfw.pages.pagecomponents.adduserpage.UserListComponent;
import com.mfw.pages.pagecomponents.adduserpage.SearchUserComponent;

public class SystemUserPage {

	private final SearchUserComponent searchUserComponent;
	private final UserListComponent userListComponent;
	
	public SystemUserPage() {
		this.searchUserComponent = new SearchUserComponent();
		this.userListComponent = new UserListComponent();
	}
	
	public UserListComponent getAddUserComponent() {
		return userListComponent;
	}
}
