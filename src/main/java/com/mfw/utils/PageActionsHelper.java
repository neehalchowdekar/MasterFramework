package com.mfw.utils;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
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
	
	public static String getAttribute(By by, Function<WebElement, String> attributeFunction) {
		return attributeFunction.apply(DriverManager.getDriver().findElement(by));
	}
	
	public static boolean isPresent(By by, Predicate<WebElement> elementPredicate) {
		try {
			return elementPredicate.test(DriverManager.getDriver().findElement(by));
		} catch (NoSuchElementException e) {
			return false;
		}
		
	}

}
