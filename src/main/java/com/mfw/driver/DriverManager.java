package com.mfw.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
	
	// This will only work for parallel execution with the 
	// web test -> web and mobile test -> mobile
	// not in terms of 
	// web test -> mobile test -> web test
	
	
	private DriverManager() {}
	
	private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		return THREAD_LOCAL.get();
	}
	
	public static void setDriver(WebDriver driver) {
		THREAD_LOCAL.set(driver);
	}
	
	public static void unload() {
		THREAD_LOCAL.remove();
	}

}
