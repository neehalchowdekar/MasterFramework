package com.mfw.driver.web.remote;

import org.openqa.selenium.WebDriver;

import com.mfw.driver.manager.web.remote.selenium.SeleniumGridChromeManager;
import com.mfw.driver.manager.web.remote.selenium.SeleniumGridFireFoxManager;
import com.mfw.enums.BrowserType;

public final class SeleniumGridFactory {
	
	private SeleniumGridFactory() {}
	
	public static WebDriver getDriver(BrowserType browserType) {
		return browserType == BrowserType.CHROME 
				? SeleniumGridChromeManager.getDriver()
				: SeleniumGridFireFoxManager.getDriver();						
	}
	

}
