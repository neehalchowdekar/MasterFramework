package com.mfw.driver.manager.web.remote.browserstack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.mfw.config.factory.BrowserStackConfigFactory;

public final class BrowserStackFireFoxManager {
	
	private BrowserStackFireFoxManager() {}

	public static WebDriver getDriver() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browser", "firefox");
		capabilities.setCapability("browser_version", "latest");
		capabilities.setCapability("os", "windows");
		capabilities.setCapability("os_version", "11");
		return new RemoteWebDriver(BrowserStackConfigFactory.getConfig().browserStackURL(),capabilities);
	}

}
