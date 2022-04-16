package com.mfw.driver.factory;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import com.mfw.driver.IMobileDriver;
import com.mfw.driver.IWebDriver;
import com.mfw.driver.LocalMobileDriverImpl;
import com.mfw.driver.LocalWebDriverImpl;
import com.mfw.driver.RemoteMobileDriverImpl;
import com.mfw.driver.RemoteWebDriverImpl;
import com.mfw.enums.RunModeType;

public final class DriverFactory {

	private DriverFactory() {}
	
	// Using Supplier Interface here bcoz it gives u lazy evaluations, so u can build the object only it is needed
	
	
	// Mainly the DriverFactory have to only return the implementation, basically now the getDriver method will 
	// fetch data with respect to RunModeType i.e Local or remote
	
	private static final Map<RunModeType, Supplier<IWebDriver>> WEB = new EnumMap<>(RunModeType.class);
	private static final Map<RunModeType, Supplier<IMobileDriver>> MOBILE = new EnumMap<>(RunModeType.class);
	
	static {
		WEB.put(RunModeType.LOCAL, LocalWebDriverImpl::new);
		WEB.put(RunModeType.REMOTE, RemoteWebDriverImpl::new);
		MOBILE.put(RunModeType.LOCAL, LocalMobileDriverImpl::new);
		MOBILE.put(RunModeType.REMOTE, RemoteMobileDriverImpl::new);
	}
	
	

	public static IWebDriver getDriverForWeb(RunModeType runModeType) {
//		return webDriverData.getRunModeType() == RunModeType.LOCAL 
//				? new LocalWebDriverImpl().getDriver(webDriverData)
//				: new RemoteWebDriverImpl().getDriver(webDriverData);
		return WEB.get(runModeType).get();
	}

	public static IMobileDriver getDriverForMobile(RunModeType runModeType) {
//		return mobileDriverData.getRunModeType() == RunModeType.LOCAL 
//				? new LocalMobileDriverImpl().getDriver(mobileDriverData)
//				: new RemoteMobileDriverImpl().getDriver(mobileDriverData);
		return MOBILE.get(runModeType).get();
	}
}
