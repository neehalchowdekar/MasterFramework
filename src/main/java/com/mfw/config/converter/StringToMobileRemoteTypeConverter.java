package com.mfw.config.converter;

import java.lang.reflect.Method;
import org.aeonbits.owner.Converter;

import com.mfw.enums.MobileRemoteModeType;

public class StringToMobileRemoteTypeConverter implements Converter<MobileRemoteModeType> {

	@Override
	public MobileRemoteModeType convert(Method method, String runMode) {
		return MobileRemoteModeType.valueOf(runMode.toUpperCase());
	}
}
