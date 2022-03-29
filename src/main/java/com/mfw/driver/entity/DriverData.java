package com.mfw.driver.entity;

import com.mfw.enums.BrowserRemoteModeType;
import com.mfw.enums.BrowserType;
import com.mfw.enums.MobilePlatformType;
import com.mfw.enums.MobileRemoteModeType;
import com.mfw.enums.RunModeType;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DriverData {
	
	private BrowserType browserType;
	private BrowserRemoteModeType browserRemoteModeType;
	private MobilePlatformType mobilePlatformType;
	private RunModeType runModeType;
	private MobileRemoteModeType mobileRemoteModeType;

}
