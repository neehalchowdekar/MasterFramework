package com.mfw.driver.factory.mobile.remote;

import java.util.EnumMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import java.util.function.Supplier;

import com.mfw.driver.manager.mobile.remote.saucelabs.SauceLabsAndroidManager;
import com.mfw.enums.MobilePlatformType;

public final class SauceLabsMobileFactory {
	
	private SauceLabsMobileFactory() {
		
	}
	
	private static final Map<MobilePlatformType, Supplier<WebDriver>> MAP = new EnumMap<>(MobilePlatformType.class);
	
	static {
		MAP.put(MobilePlatformType.ANDROID, SauceLabsAndroidManager :: getDriver);
	}
	
	public static WebDriver getDriver(MobilePlatformType mobilePlatformType) {
		return MAP.get(mobilePlatformType).get();
	}

}
