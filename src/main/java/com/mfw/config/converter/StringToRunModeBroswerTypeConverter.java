package com.mfw.config.converter;

import java.lang.reflect.Method;
import org.aeonbits.owner.Converter;
import com.mfw.enums.RunModeBrowserType;

public class StringToRunModeBroswerTypeConverter implements Converter<RunModeBrowserType> {

	@Override
	public RunModeBrowserType convert(Method method, String runMode) {
		return RunModeBrowserType.valueOf(runMode.toUpperCase());
	}
}
