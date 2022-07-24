package com.mfw.driver;

import org.openqa.selenium.WebDriver;
import static com.mfw.enums.PlatformType.*;
import com.mfw.enums.PlatformType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import static java.lang.ThreadLocal.withInitial;
import java.util.EnumMap;
import java.util.Map;

public final class DriverManager {

	// This will only work for parallel execution with the
	// web test -> web and mobile test -> mobile
	// Problem: not in terms of web test -> mobile test -> web test

	// Solution : here will have 2 thread local one for web another for mobile
	// 1. Web, 2. Mobile
	// To store both these need a data structure
	// LIST --> we have to get it on the bases of indexes.
	// MAP --> K,V pair (WEB, WEB_DRIVER_THREAD_LOCAL), (MOBILE, MOBILE_DRIVER_THREAD_LOCAL)
	// At particular instance, context --> WEB, MOBILE

	private DriverManager() {
	}

	private static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new ThreadLocal<>();
	private static final ThreadLocal<WebDriver> MOBILE_DRIVER_THREAD_LOCAL = new ThreadLocal<>();
	private static final ThreadLocal<PlatformType> CONTEXT = withInitial(() -> WEB);
	private static final Map<PlatformType, ThreadLocal<WebDriver>> DRIVER_MAP = new EnumMap<>(PlatformType.class);

	public static WebDriver getDriver() {
		return CONTEXT.get() == WEB 
				? WEB_DRIVER_THREAD_LOCAL.get()
				: MOBILE_DRIVER_THREAD_LOCAL.get(); 
	}

	public static void setDriver(WebDriver driver) {
		if (isMobileDriver(driver)) {
			MOBILE_DRIVER_THREAD_LOCAL.set(driver);
			DRIVER_MAP.put(MOBILE, MOBILE_DRIVER_THREAD_LOCAL);
			CONTEXT.set(MOBILE);
		} else {
			WEB_DRIVER_THREAD_LOCAL.set(driver);
			DRIVER_MAP.put(WEB, WEB_DRIVER_THREAD_LOCAL);
			CONTEXT.set(WEB);
		}
	}

	public static boolean isMobileDriver(WebDriver driver) {
		return driver instanceof AndroidDriver || driver instanceof IOSDriver;
	}

	
	/**
	 * using unload bcoz it can cause memory leaks, so instead of setting back to null which will make sure
	 * all the value are removed
	 */
	public static void unload() {
		WEB_DRIVER_THREAD_LOCAL.remove();
		MOBILE_DRIVER_THREAD_LOCAL.remove();
		CONTEXT.remove();
	}

}
