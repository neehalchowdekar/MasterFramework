package com.mfw.config;

import java.net.URL;

import org.aeonbits.owner.Config;
import com.mfw.config.converter.StringToBroswerTypeConverter;
import com.mfw.config.converter.StringToMobileRemoteTypeConverter;
import com.mfw.config.converter.StringToRemoteModeBroswerTypeConverter;
import com.mfw.config.converter.StringToRunModeTypeConverter;
import com.mfw.config.converter.StringToURLTypeConverter;
import com.mfw.enums.BrowserRemoteModeType;
import com.mfw.enums.BrowserType;
import com.mfw.enums.MobileRemoteModeType;
import com.mfw.enums.RunModeType;

/**
 * @author Neehal(neehal@lenskart.in)
 * 
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
	"system:properties",
	"system:env",
	"file:${user.dir}/src/test/resources/config.properties",
	"file:${user.dir}/src/test/resources/staging-config.properties",
	"file:${user.dir}/src/test/resources/dev-config.properties",
	"file:${user.dir}/src/test/resources/preprod.properties"
})
public interface FrameworkConfig extends Config{
	
	@DefaultValue("staging")
	String environment();
	
	@Key("${environment}.webUrl")
	String webUrl();
	
	@DefaultValue("false")
	boolean headless();
	
	@DefaultValue("CHROME")
	@ConverterClass(StringToBroswerTypeConverter.class)
	BrowserType browser();
	
	@Key("runModeBrowser")
	@ConverterClass(StringToRunModeTypeConverter.class)
	RunModeType browserRunMode();
	
	@Key("runMobileMode")
	@ConverterClass(StringToRunModeTypeConverter.class)
	RunModeType mobileRunMode();
	
	@Key("browserRemoteMode")
	@ConverterClass(StringToRemoteModeBroswerTypeConverter.class)
	BrowserRemoteModeType browserRemoteMode();
	
	@Key("mobileRemoteMode")
	@ConverterClass(StringToMobileRemoteTypeConverter.class)
	MobileRemoteModeType mobileRemoteMode();
	
	@ConverterClass(StringToURLTypeConverter.class)
	URL seleniumGridURL();
	
	@ConverterClass(StringToURLTypeConverter.class)
	URL selenoidGridURL();

	@ConverterClass(StringToURLTypeConverter.class)
	@DefaultValue("http://127.0.0.1:4723/wd/hub")
	URL localAppiumServerUrl();
}
