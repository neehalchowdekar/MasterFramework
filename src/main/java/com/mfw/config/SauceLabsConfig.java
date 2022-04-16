package com.mfw.config;

import java.net.URL;
import org.aeonbits.owner.Config;
import com.mfw.config.converter.StringToURLTypeConverter;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
	"file:${user.dir}/src/test/resources/sauce-labs.properties",
})
public interface SauceLabsConfig extends Config {
	
	@Key("username")
	String userName();
	
	String key();
	
	@DefaultValue("saucelabsendpoint")
	@ConverterClass(StringToURLTypeConverter.class)
	URL sauceLabsUrl();
	

}
