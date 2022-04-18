package com.mfw.tests.web.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.mfw.driver.Driver;

public class WebBase {
	
	@BeforeMethod
	public void setUp() {
		Driver.initDriverForWeb();
	}
	
	@AfterMethod
	public void tearDown() {
		Driver.quitDriver();
	}

}
