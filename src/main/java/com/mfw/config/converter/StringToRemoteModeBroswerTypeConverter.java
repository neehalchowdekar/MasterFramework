package com.mfw.config.converter;

import java.lang.reflect.Method;
import org.aeonbits.owner.Converter;
import com.mfw.enums.BrowserRemoteModeType;

public class StringToRemoteModeBroswerTypeConverter implements Converter<BrowserRemoteModeType> {

	@Override
	public BrowserRemoteModeType convert(Method method, String runMode) {
		return BrowserRemoteModeType.valueOf(runMode.toUpperCase());
	}
}
