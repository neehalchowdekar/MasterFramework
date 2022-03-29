package com.mfw.driver.factory.mobile.remote;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;

import com.mfw.enums.MobilePlatformType;
import com.mfw.enums.MobileRemoteModeType;

public final class RemoteMobileDriverFactory {

	private RemoteMobileDriverFactory() {
	}
	
	private static final Map<MobileRemoteModeType, Function<MobilePlatformType, WebDriver>> MAP = 
			new EnumMap<>(MobileRemoteModeType.class);
//	private static final Function<BrowserType, WebDriver> SELENIUM = SeleniumGridFactory :: getDriver;
//	private static final Function<BrowserType, WebDriver> SELENOID = SelenoidFactory :: getDriver;
//	private static final Function<BrowserType, WebDriver> BROWSER_STACK = BrowserStackFactory :: getDriver;
//	
	static {
		MAP.put(MobileRemoteModeType.SAUCE_LABS, SauceLabsMobileFactory :: getDriver);
		MAP.put(MobileRemoteModeType.BROWSER_STACK, BrowserStackMobileFactory :: getDriver);
	}
	
	public static WebDriver getDriver(MobileRemoteModeType browserRemoteModeType, MobilePlatformType browserType) {
		return MAP.get(browserRemoteModeType).apply(browserType);
	}

	/*
	 * public static WebDriver getDriver(BrowserRemoteModeType
	 * browserRemoteModeType, BrowserType browserType) {
	 * 
	 * if (browserRemoteModeType == BrowserRemoteModeType.SELENIUM) { return
	 * SeleniumGridFactory.getDriver(browserType); } else if (browserRemoteModeType
	 * == BrowserRemoteModeType.SELENOID) { return
	 * SelenoidFactory.getDriver(browserType); } else if (browserRemoteModeType ==
	 * BrowserRemoteModeType.BROWSER_STACK) { return
	 * BrowserStackFactory.getDriver(browserType); } else {
	 * 
	 * } return null; }
	 */

}
