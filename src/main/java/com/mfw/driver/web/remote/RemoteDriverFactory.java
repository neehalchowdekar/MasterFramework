package com.mfw.driver.web.remote;

import org.openqa.selenium.WebDriver;
import com.mfw.enums.BrowserRemoteModeType;
import com.mfw.enums.BrowserType;

public final class RemoteDriverFactory {

	private RemoteDriverFactory() {
	}

	public static WebDriver getDriver(BrowserRemoteModeType browserRemoteModeType, BrowserType browserType) {

		if (browserRemoteModeType == BrowserRemoteModeType.SELENIUM) {
			return SeleniumGridFactory.getDriver(browserType);
		} else if (browserRemoteModeType == BrowserRemoteModeType.SELENOID) {
			return SelenoidFactory.getDriver(browserType);
		} else if (browserRemoteModeType == BrowserRemoteModeType.BROWSER_STACK) {
			return BrowserStackFactory.getDriver(browserType);
		} else {

		}
		return null;
	}

}
