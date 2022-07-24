package com.mfw.driver.factory.web.local;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;

import com.mfw.driver.manager.web.local.ChromeDriverManager;
import com.mfw.driver.manager.web.local.FirefoxDriverManager;
import com.mfw.enums.BrowserType;

// Using final class here so that no one can extend this class
public final class LocalDriverFactory {

	private LocalDriverFactory() {
	}

	private static final Map<BrowserType, Supplier<WebDriver>> MAP = new EnumMap<>(BrowserType.class);
//	private static final Supplier<WebDriver> CHROME = ChromeDriverManager :: getDriver;
//	private static final Supplier<WebDriver> FIREFOX = FirefoxDriverManager :: getDriver;

	static {
		MAP.put(BrowserType.CHROME, ChromeDriverManager::getDriver);
		MAP.put(BrowserType.FIREFOX, FirefoxDriverManager::getDriver);
	}

	public static WebDriver getDriver(BrowserType browserType) {
		return MAP.get(browserType).get();
	}

//	static WebDriver driver;

//	public static WebDriver getDriver(BrowserType browserType) {
//		return (isBrowserChrome(browserType)) ? ChromeDriverManager.getDriver() : FirefoxDriverManager.getDriver();
//	}
//
//	public static boolean isBrowserChrome(BrowserType browserType) {
//		return browserType == BrowserType.CHROME;
//	}

}
