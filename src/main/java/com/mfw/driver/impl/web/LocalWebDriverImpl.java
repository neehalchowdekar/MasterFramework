package com.mfw.driver.impl.web;

import org.openqa.selenium.WebDriver;

import com.mfw.driver.IWebDriver;
import com.mfw.driver.entity.WebDriverData;
import com.mfw.driver.factory.web.local.LocalDriverFactory;

public class LocalWebDriverImpl implements IWebDriver {

	@Override
	public WebDriver getDriver(WebDriverData driverData) {
		return LocalDriverFactory.getDriver(driverData.getBrowserType());
	}
	
	

}
