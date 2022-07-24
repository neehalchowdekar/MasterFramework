package com.mfw.utils;

import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.mfw.driver.DriverManager;

public class PageActionsHelper {
	
	private PageActionsHelper() {}
	
	public static void waitAndClick(By by) {
		DriverManager.getDriver().findElement(by).click();
	}
	
	public static void waitAndSendKeys(By by, String value) {
		DriverManager.getDriver().findElement(by).sendKeys(value);
	}
	
	public static void select(By by, Consumer<Select> consumer) {
		consumer.accept(new Select(DriverManager.getDriver().findElement(by)));
	}
	
	public static String getText(By by) {
		return DriverManager.getDriver().findElement(by).getText();
	}

}
