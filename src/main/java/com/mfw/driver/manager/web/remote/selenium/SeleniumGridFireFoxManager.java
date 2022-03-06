package com.mfw.driver.manager.web.remote.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.mfw.config.factory.ConfigFactory;
import com.mfw.enums.BrowserType;

public final class SeleniumGridFireFoxManager {
	
	private SeleniumGridFireFoxManager() {}
	
	public static WebDriver getDriver() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(BrowserType.FIREFOX.toString());
		return new RemoteWebDriver(ConfigFactory.getConfig().seleniumGridURL(),capabilities);
	}

}
