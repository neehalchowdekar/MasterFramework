package com.mfw.driver.web.local;

import org.openqa.selenium.WebDriver;

import com.mfw.driver.manager.web.local.ChromeDriverManager;
import com.mfw.driver.manager.web.local.FirefoxDriverManager;
import com.mfw.enums.BrowserType;

public final class LocalDriverFactory {

	private LocalDriverFactory() {
	}

	static WebDriver driver;

	public static WebDriver getDriver(BrowserType browserType) {
		return (isBrowserChrome(browserType)) ? ChromeDriverManager.getDriver() : FirefoxDriverManager.getDriver();
	}

	public static boolean isBrowserChrome(BrowserType browserType) {
		return browserType == BrowserType.CHROME;
	}

}
