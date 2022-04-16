package com.mfw.driver.factory.mobile.local;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;

import com.mfw.driver.manager.mobile.local.AndroidManager;
import com.mfw.driver.manager.mobile.local.IosManager;
import com.mfw.enums.MobilePlatformType;

public final class LocalMobileDriverFactory {
	
	private LocalMobileDriverFactory() {}
	
	// Using Supplier here bcoz it gives u lazy evaluations, so u can build the object only it is needed
	
	private static final Map<MobilePlatformType, Supplier<WebDriver>> MAP = 
			new EnumMap<>(MobilePlatformType.class);
	
	static {
		MAP.put(MobilePlatformType.ANDROID, AndroidManager :: getDriver);
		MAP.put(MobilePlatformType.IOS, IosManager :: getDriver);
	}
	
	public static WebDriver getDriver(MobilePlatformType mobilePlatformType) {
		return MAP.get(mobilePlatformType).get();
	}
	
}
