package com.mfw.driver;

import org.openqa.selenium.WebDriver;

import com.mfw.config.factory.ConfigFactory;
import com.mfw.driver.entity.DriverData;
import com.mfw.driver.factory.DriverFactory;
import com.mfw.driver.factory.mobile.local.LocalMobileDriverFactory;
import com.mfw.driver.factory.web.local.LocalDriverFactory;
import com.mfw.driver.factory.web.remote.RemoteDriverFactory;
import com.mfw.enums.MobilePlatformType;

public final class Driver {
	
	private Driver() {}

	public static void initDriverForWeb() {
		DriverData driverData = DriverData.builder()
								.browserType(ConfigFactory.getConfig().browser())
								.browserRemoteModeType(ConfigFactory.getConfig().browserRemoteMode())
								.runModeType(ConfigFactory.getConfig().browserRunMode())
								.build();
		WebDriver driver = DriverFactory.getDriverForWeb(driverData);
		driver.quit();
	}
	
	public static void initDriverForMobile() {
		DriverData driverData = DriverData.builder()
								.mobilePlatformType(MobilePlatformType.ANDROID)
								.mobileRemoteModeType(ConfigFactory.getConfig().mobileRemoteMode())
								.runModeType(ConfigFactory.getConfig().mobileRunMode())
								.build();
		WebDriver driver = DriverFactory.getDriverForMobile(driverData);
		driver.quit();
	}
	
	public static void quitDriver() {
		
	}

}
