package com.mfw.config.factory;

import org.aeonbits.owner.ConfigCache;
import com.mfw.config.SauceLabsConfig;


public final class SauceLabsConfigFactory {

	private SauceLabsConfigFactory() {}
	
	public static SauceLabsConfig getConfig() {
		return ConfigCache.getOrCreate(SauceLabsConfig.class);
	}
}
