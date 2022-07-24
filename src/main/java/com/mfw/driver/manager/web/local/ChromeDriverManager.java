package com.mfw.driver.manager.web.local;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.mfw.config.factory.ConfigFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public final class ChromeDriverManager {
	
	private ChromeDriverManager() {}
	
	public static ChromeDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setHeadless(ConfigFactory.getConfig().headless());
		return new ChromeDriver(chromeOptions);
	}

}
