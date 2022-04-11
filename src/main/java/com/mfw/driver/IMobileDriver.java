package com.mfw.driver;

import org.openqa.selenium.WebDriver;

import com.mfw.driver.entity.MobileDriverData;

public interface IMobileDriver {
	
	WebDriver getDriver(MobileDriverData driverData);

}
