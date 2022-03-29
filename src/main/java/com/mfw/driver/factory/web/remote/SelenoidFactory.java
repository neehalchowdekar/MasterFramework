package com.mfw.driver.factory.web.remote;

import org.openqa.selenium.WebDriver;

import com.mfw.driver.manager.web.remote.selenoid.SelenoidChromeManager;
import com.mfw.driver.manager.web.remote.selenoid.SelenoidFireFoxManager;
import com.mfw.enums.BrowserType;

public final class SelenoidFactory {
	
	private SelenoidFactory() {}
	
	public static WebDriver getDriver(BrowserType browserType) {
		return browserType == BrowserType.CHROME 
				? SelenoidChromeManager.getDriver()
				: SelenoidFireFoxManager.getDriver();
	}

}
