package com.mfw.driver.entity;

import com.mfw.enums.BrowserRemoteModeType;
import com.mfw.enums.BrowserType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WebDriverData {

	
	private BrowserType browserType;
	private BrowserRemoteModeType browserRemoteModeType;
}
