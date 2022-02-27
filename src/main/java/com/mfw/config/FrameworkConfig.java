package com.mfw.config;

import org.aeonbits.owner.Config;

import com.mfw.config.converter.StringToBroswerTypeConverter;
import com.mfw.enums.BrowserType;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
	"system:properties",
	"system:env",
	"file:${user.dir}/src/test/resources/config.properties",
})
public interface FrameworkConfig extends Config{
	
	@DefaultValue("CHROME")
	@ConverterClass(StringToBroswerTypeConverter.class)
	BrowserType browser();

}
