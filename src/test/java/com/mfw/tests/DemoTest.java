package com.mfw.tests;

import org.aeonbits.owner.ConfigCache;
import org.testng.annotations.Test;

import com.mfw.config.FrameworkConfig;
import com.mfw.config.factory.ConfigFactory;

public class DemoTest {
	
	// To make driver to run locally, remotely on browserstack, selenium grid, selenoide : chrome, firefox
	
	@Test
	public void testLogin() {
		// FrameworkConfig config = ConfigCache.getOrCreate(FrameworkConfig.class);
		
		System.out.println(ConfigFactory.getConfig().browser());
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://google.co.in");
//		driver.quit();
	}

}
