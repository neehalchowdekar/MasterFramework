package com.mfw.config;

import java.net.URL;

import org.aeonbits.owner.Config;

import com.mfw.config.converter.StringToURLTypeConverter;

public interface BrowserStackConfig extends Config{
	
	@Key("username")
	String userName();
	
	String key();
	
	@DefaultValue("https:// $(username) : $key@hub-cloud.browserstack.com/wd/hub")
	@ConverterClass(StringToURLTypeConverter.class)
	URL browserStackURL();

}
