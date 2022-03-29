package com.mfw.driver.factory.web.remote;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import org.openqa.selenium.WebDriver;
import com.mfw.driver.manager.web.remote.browserstack.BrowserStackChromeManager;
import com.mfw.driver.manager.web.remote.browserstack.BrowserStackFireFoxManager;
import com.mfw.enums.BrowserType;

public final class BrowserStackFactory {

	private BrowserStackFactory() {
	}

	private static final Map<BrowserType, Supplier<WebDriver>>  MAP = new EnumMap<>(BrowserType.class);
	
	static {
		MAP.put(BrowserType.CHROME, BrowserStackChromeManager :: getDriver);
		MAP.put(BrowserType.CHROME, BrowserStackFireFoxManager :: getDriver);
	}
	
	
	public static WebDriver getDriver(BrowserType browserType) {
		return MAP.get(browserType).get();
	}

}