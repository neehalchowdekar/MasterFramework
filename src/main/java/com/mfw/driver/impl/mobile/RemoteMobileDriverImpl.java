package com.mfw.driver.impl.mobile;

import org.openqa.selenium.WebDriver;

import com.mfw.driver.IMobileDriver;
import com.mfw.driver.entity.MobileDriverData;
import com.mfw.driver.factory.mobile.remote.RemoteMobileDriverFactory;

public class RemoteMobileDriverImpl implements IMobileDriver {

	@Override
	public WebDriver getDriver(MobileDriverData driverData) {
		return RemoteMobileDriverFactory.getDriver(driverData.getMobileRemoteModeType(),
				driverData.getMobilePlatformType());
	}

}
