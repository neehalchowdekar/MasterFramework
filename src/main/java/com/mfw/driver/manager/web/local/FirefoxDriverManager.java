package com.mfw.driver.manager.web.local;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class FirefoxDriverManager {
	
	private FirefoxDriverManager() {}
	
	public static FirefoxDriver getDriver() {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}

}
