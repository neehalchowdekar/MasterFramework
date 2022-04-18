package com.mfw.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

import com.mfw.config.factory.ConfigFactory;
import com.mfw.driver.entity.MobileDriverData;
import com.mfw.driver.entity.WebDriverData;
import com.mfw.driver.factory.DriverFactory;
import com.mfw.enums.MobilePlatformType;

public final class Driver {

	private Driver() {
	}

	// public static WebDriver driver;
	// Problem : It is shared between thread, not thread safe
	// driver variable will be read and written
	// The solution is to use ThreadLocal class

	public static void initDriverForWeb() {
		if(Objects.isNull(DriverManager.getDriver())){
		WebDriverData driverData = new WebDriverData(ConfigFactory.getConfig().browser(), ConfigFactory.getConfig().browserRemoteMode());
//		WebDriverData driverData = WebDriverData.builder()
//								.browserType(ConfigFactory.getConfig().browser())
//								.browserRemoteModeType(ConfigFactory.getConfig().browserRemoteMode())
//								.build();
		WebDriver driver = DriverFactory
				.getDriverForWeb(ConfigFactory.getConfig().browserRunMode())
				.getDriver(driverData);
		DriverManager.setDriver(driver);
		}
	}

	public static void initDriverForMobile() {
		MobileDriverData driverData = new MobileDriverData(MobilePlatformType.ANDROID,
				ConfigFactory.getConfig().mobileRemoteMode());
//		MobileDriverData driverData = MobileDriverData.builder()
//								.mobilePlatformType(MobilePlatformType.ANDROID)
//								.mobileRemoteModeType(ConfigFactory.getConfig().mobileRemoteMode())
//								.build();
		WebDriver driver = DriverFactory
				.getDriverForMobile(ConfigFactory.getConfig().mobileRunMode())
				.getDriver(driverData);
		DriverManager.setDriver(driver);

	}

	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
		DriverManager.getDriver().quit();
		DriverManager.unload();
		}
	}

}
