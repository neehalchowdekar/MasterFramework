package com.mfw.driver.factory.web.remote;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import com.mfw.enums.BrowserRemoteModeType;
import com.mfw.enums.BrowserType;

public final class RemoteDriverFactory {

	private RemoteDriverFactory() {
	}
	
	private static final Map<BrowserRemoteModeType, Function<BrowserType, WebDriver>> MAP = 
			new EnumMap<>(BrowserRemoteModeType.class);
//	private static final Function<BrowserType, WebDriver> SELENIUM = SeleniumGridFactory :: getDriver;
//	private static final Function<BrowserType, WebDriver> SELENOID = SelenoidFactory :: getDriver;
//	private static final Function<BrowserType, WebDriver> BROWSER_STACK = BrowserStackFactory :: getDriver;
//	
	static {
		MAP.put(BrowserRemoteModeType.SELENIUM, SeleniumGridFactory :: getDriver);
		MAP.put(BrowserRemoteModeType.SELENOID, SelenoidFactory :: getDriver);
		MAP.put(BrowserRemoteModeType.BROWSER_STACK, BrowserStackFactory :: getDriver);
	}
	
	public static WebDriver getDriver(BrowserRemoteModeType browserRemoteModeType, BrowserType browserType) {
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
