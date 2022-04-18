package com.mfw.tests.mobile.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.mfw.driver.Driver;

public class MobileBase {
	
	@BeforeMethod
	public void setUp() {
		Driver.initDriverForMobile();
	}
	
	@AfterMethod
	public void tearDown() {
		Driver.quitDriver();
	}


}
