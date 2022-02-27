package com.mfw.config.converter;

import java.lang.reflect.Method;
import java.util.Map;

import org.aeonbits.owner.Converter;

import com.mfw.enums.BrowserType;

public class StringToBroswerTypeConverter implements Converter<BrowserType> {

	@Override
	public BrowserType convert(Method method, String browserName) {
		Map<String, BrowserType> stringToBrowserTypeMap = Map.
				of("CHROME", BrowserType.CHROME, 
					"FIREFOX", BrowserType.FIREFOX);
		return stringToBrowserTypeMap.getOrDefault(browserName.toUpperCase(), BrowserType.CHROME);
	}
}
