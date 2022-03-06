package com.mfw.config;

import java.net.URL;

import org.aeonbits.owner.Config;

import com.mfw.config.converter.StringToBroswerTypeConverter;
import com.mfw.config.converter.StringToRemoteModeBroswerTypeConverter;
import com.mfw.config.converter.StringToRunModeBroswerTypeConverter;
import com.mfw.config.converter.StringToURLTypeConverter;
import com.mfw.enums.BrowserRemoteModeType;
import com.mfw.enums.BrowserType;
import com.mfw.enums.RunModeBrowserType;

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
	
	@Key("runModeBrowser")
	@ConverterClass(StringToRunModeBroswerTypeConverter.class)
	RunModeBrowserType runModeForBrowser();
	
	@Key("browserRemoteMode")
	@ConverterClass(StringToRemoteModeBroswerTypeConverter.class)
	BrowserRemoteModeType browserRemoteMode();
	
	@ConverterClass(StringToURLTypeConverter.class)
	URL seleniumGridURL();
	
	@ConverterClass(StringToURLTypeConverter.class)
	URL selenoidGridURL();

}
