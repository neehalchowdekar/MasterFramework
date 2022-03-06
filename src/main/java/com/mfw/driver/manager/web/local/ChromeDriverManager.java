package com.mfw.driver.manager.web.local;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class ChromeDriverManager {
	
	private ChromeDriverManager() {}
	
	public static ChromeDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}

}
