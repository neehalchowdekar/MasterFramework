package com.mfw.driver.web.remote;

import org.openqa.selenium.WebDriver;

import com.mfw.driver.manager.web.remote.browserstack.BrowserStackChromeManager;
import com.mfw.driver.manager.web.remote.browserstack.BrowserStackFireFoxManager;
import com.mfw.enums.BrowserType;

public final class BrowserStackFactory {

	private BrowserStackFactory() {
	}

	public static WebDriver getDriver(BrowserType browserType) {
		return browserType == BrowserType.CHROME ? BrowserStackChromeManager.getDriver()
				: BrowserStackFireFoxManager.getDriver();
	}

}
