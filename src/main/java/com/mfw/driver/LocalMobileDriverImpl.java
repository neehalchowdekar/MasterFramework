package com.mfw.driver;

import org.openqa.selenium.WebDriver;
import com.mfw.driver.entity.MobileDriverData;
import com.mfw.driver.factory.mobile.local.LocalMobileDriverFactory;

public class LocalMobileDriverImpl implements IMobileDriver {

	@Override
	public WebDriver getDriver(MobileDriverData driverData) {
		return LocalMobileDriverFactory.getDriver(driverData.getMobilePlatformType());
	}

}
