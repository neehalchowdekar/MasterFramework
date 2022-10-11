package com.mfw.tests.web.base;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.mfw.pages.LoginPage;
import com.mfw.pages.enums.loginuser.LoginUserScenarioType;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import io.github.sskorol.core.DataSupplier;

public class LoginTest extends WebBase {
	
	
	@Test(dataProvider = "getLoginData")
	public void loginTest(LoginUserScenarioType loginUserScenarioType) {
		boolean isMessageDisplayed = new LoginPage()
				.loginDetails(loginUserScenarioType.getLoginData(), loginUserScenarioType.getPredicate());
		
		Assertions.assertThat(isMessageDisplayed)
		.withFailMessage(() -> loginUserScenarioType.getLoginData().getMessage())
		.isTrue();
	}
	
	
	@DataSupplier(runInParallel = true)
	public Stream<LoginUserScenarioType> getLoginData(){
		FixtureFactoryLoader.loadTemplates("com.mfw.fixtures");
		return Stream.of(LoginUserScenarioType.values());
	}

}
