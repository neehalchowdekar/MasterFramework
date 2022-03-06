package com.mfw.driver;

import org.openqa.selenium.WebDriver;

import com.mfw.config.factory.ConfigFactory;
import com.mfw.driver.web.local.LocalDriverFactory;

public final class Driver {
	
	private Driver() {}

	public static void initDriver() {
		WebDriver driver =  LocalDriverFactory.getDriver(ConfigFactory.getConfig().browser());
		driver.get("https://www.google.co.in/");
	}
	
	public static void quitDriver() {
		
	}

}
