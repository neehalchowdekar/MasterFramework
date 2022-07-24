package com.mfw.tests.web.base;

import org.testng.annotations.Test;
import com.mfw.config.factory.ConfigFactory;
import com.mfw.driver.Driver;

public class DemoTest {
	
	// To make driver to run locally, remotely on browserstack, selenium grid, selenoide : chrome, firefox
	
	@Test
	public void testLogin() {
		
		Driver.initDriverForWeb();
		//Driver.initDriverForMobile();
		// FrameworkConfig config = ConfigCache.getOrCreate(FrameworkConfig.class);	
		//System.out.println(ConfigFactory.getConfig().browser());
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://google.co.in");
//		driver.quit();
	}

}
