package com.mfw.pages;

import com.mfw.pages.enums.topmenucomponent.MenuType;
import com.mfw.pages.enums.topmenucomponent.SubMenuType;
import com.mfw.pages.pagecomponents.homepage.TopMenuComponent;

public class HomePage {
	
	 private TopMenuComponent topMenuComponent;
	 
	 public HomePage() {
		 this.topMenuComponent = new TopMenuComponent();
	 }
	 
	 public TopMenuComponent getTopMenuComponent() {
		 return topMenuComponent;
	 }
	 
	 public SystemUserPage navigateToAddUserPage() {
			topMenuComponent
			.clickOnMenuItems(MenuType.ADMIN)
			.clickOnSubMenuItems(SubMenuType.USER_MANAGEMENT)
			.clickOnSubMenuItems(SubMenuType.USERS);
			return new SystemUserPage();
			
		}

}
