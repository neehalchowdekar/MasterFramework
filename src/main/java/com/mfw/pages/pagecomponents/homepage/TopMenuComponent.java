package com.mfw.pages.pagecomponents.homepage;

import org.openqa.selenium.By;

import com.mfw.pages.enums.topmenucomponent.MenuType;
import com.mfw.pages.enums.topmenucomponent.SubMenuType;
import com.mfw.utils.PageActionsHelper;

public class TopMenuComponent {

	
	private static final String MENU = "//b[text()='%s']/parent::a";
	private static final String SUB_MENU = "//a[text()='%s']";
	private static final By WELCOME_TEXT = By.id("welcome");
	
	
	public TopMenuComponent clickOnMenuItems(MenuType menuType) {
		String xpath = String.format(MENU, menuType.getName());
		PageActionsHelper.waitAndClick(By.xpath(xpath));
		return this;
	}
	
	public TopMenuComponent clickOnSubMenuItems(SubMenuType subMenuType) {
		String xpath = String.format(SUB_MENU, subMenuType.getName());
		PageActionsHelper.waitAndClick(By.xpath(xpath));
		return this;
	}
	
	public boolean isWelcomeTextDisplayed() {
		return PageActionsHelper.isPresent(WELCOME_TEXT, e -> e.isDisplayed());
	}
}

