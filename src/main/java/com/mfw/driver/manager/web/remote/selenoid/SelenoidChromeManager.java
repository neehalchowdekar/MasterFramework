package com.mfw.driver.manager.web.remote.selenoid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.mfw.config.factory.ConfigFactory;

public class SelenoidChromeManager {
	
	private SelenoidChromeManager() {}

	public static WebDriver getDriver() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("browserVersion", "97.0");
		capabilities.setCapability("enableVNC", true);
		capabilities.setCapability("enableVideo", false);
		return new RemoteWebDriver(ConfigFactory.getConfig().selenoidGridURL(),capabilities);
	}

}
