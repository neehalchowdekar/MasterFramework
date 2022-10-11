package com.mfw.tests.web.base;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.mfw.driver.DriverManager;

public class NexusTest extends WebBase{
	
	@Test
	public void loginTest() {
		boolean result = DriverManager.getDriver().findElement(By.name("email")).isDisplayed();
		assertTrue(result);
	}

}
