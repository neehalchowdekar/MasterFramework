package com.mfw.config.converter;

import java.lang.reflect.Method;
import java.net.URL;
import org.aeonbits.owner.Converter;

import lombok.SneakyThrows;

public class StringToURLTypeConverter implements Converter<URL> {

	@SneakyThrows
	@Override
	public URL convert(Method method, String url) {
		return new URL(url);
	}
}
