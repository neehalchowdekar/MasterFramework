package com.mfw.driver.impl.web;

import org.openqa.selenium.WebDriver;

import com.mfw.driver.IWebDriver;
import com.mfw.driver.entity.WebDriverData;
import com.mfw.driver.factory.web.remote.RemoteDriverFactory;

public class RemoteWebDriverImpl implements IWebDriver{

	@Override
	public WebDriver getDriver(WebDriverData driverData) {
		return RemoteDriverFactory.getDriver(driverData.getBrowserRemoteModeType(), driverData.getBrowserType());
	}

}
