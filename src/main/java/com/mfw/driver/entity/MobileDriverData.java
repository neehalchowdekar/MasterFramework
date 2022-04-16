package com.mfw.driver.entity;

import com.mfw.enums.MobilePlatformType;
import com.mfw.enums.MobileRemoteModeType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MobileDriverData {

	private MobilePlatformType mobilePlatformType;
	private MobileRemoteModeType mobileRemoteModeType;

}
