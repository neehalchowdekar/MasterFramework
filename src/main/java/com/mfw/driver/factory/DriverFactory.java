package com.mfw.driver.factory;

import org.openqa.selenium.WebDriver;

import com.mfw.driver.entity.DriverData;
import com.mfw.driver.factory.mobile.local.LocalMobileDriverFactory;
import com.mfw.driver.factory.mobile.remote.RemoteMobileDriverFactory;
import com.mfw.driver.factory.web.local.LocalDriverFactory;
import com.mfw.driver.factory.web.remote.RemoteDriverFactory;
import com.mfw.enums.RunModeType;

public final class DriverFactory {
	
	private DriverFactory() {}
	
	public static WebDriver getDriverForWeb(DriverData driverData) {
		if(driverData.getRunModeType() == RunModeType.LOCAL) {
			return LocalDriverFactory.getDriver(driverData.getBrowserType());
		}else {
			return RemoteDriverFactory.getDriver(driverData.getBrowserRemoteModeType(), driverData.getBrowserType());
		}
	}
	
	public static WebDriver getDriverForMobile(DriverData driverData) {
		if(driverData.getRunModeType() == RunModeType.LOCAL) {
			return LocalMobileDriverFactory.getDriver(driverData.getMobilePlatformType());
		}else {
			return RemoteMobileDriverFactory.getDriver(driverData.getMobileRemoteModeType(), driverData.getMobilePlatformType());
		}
	}
}
