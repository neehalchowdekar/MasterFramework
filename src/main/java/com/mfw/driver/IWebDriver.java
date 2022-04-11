package com.mfw.driver;

import org.openqa.selenium.WebDriver;

import com.mfw.driver.entity.WebDriverData;

public interface IWebDriver {

	WebDriver getDriver(WebDriverData driverData);
}
