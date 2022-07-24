package com.mfw.tests.web.base;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import com.mfw.pages.LoginPage;
import com.mfw.pages.enums.adduser.AddUserScenarioType;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import io.github.sskorol.core.DataSupplier;

public class AddUsersTest extends WebBase {
	
	// To make driver to run locally, remotely on browserstack, selenium grid, selenoide : chrome, firefox
	
//	BiPredicate<UserData, AddUserComponent> justEmployeeNamePredicate = (userData, addComponent) -> {
//		addComponent.setEmployeeTextBox(userData.getEmployeeName());
//		return addComponent.isErrorMessageDisplayed();
//		};
//		
//	BiPredicate<UserData, AddUserComponent> validPredicate = (userData, addComponent) -> {
//		addComponent
//		.setUserRoleDropDown(userData.getUserRole())
//		.setEmployeeTextBox(userData.getEmployeeName())
//		.setUserName(userData.getUserName())
//		.setStatusDropDown(userData.getStatus())
//		.setPasswordTextBox(userData.getPassword())
//		.setConfirmPasswordTextBox(userData.getPassword());
//		return addComponent.isSuccessMessageDisplayed();
//			};
	
	
	@Test(dataProvider = "getData")
	public void testAddUsers(AddUserScenarioType addUserScenarioType) {
		
	boolean isMessageDisplayed = new LoginPage()
		.loginToApplication("Admin", "admin123")
		.navigateToAddUserPage()
		.getAddUserComponent()
		.setAddButton()
		.fillDetails(addUserScenarioType.getUserData(), addUserScenarioType.getPredicate());
	
	Assertions.assertThat(isMessageDisplayed)
	.withFailMessage(() -> addUserScenarioType.getUserData().getMessage())
	.isTrue();
	}
	
//	@DataProvider
//	public Object[][] getData(){
//		FixtureFactoryLoader.loadTemplates("com.mfw.fixtures");
//		UserData valid = Fixture.from(UserData.class).gimme("valid");
//		UserData justEmployeeName = Fixture.from(UserData.class).gimme("just_employeename");
////		UserData users = new UserData("Admin", "adarerfa", "asdaeeff", "Enabled", "asdasdas");
//		return new Object[][] {
//			{justEmployeeName, justEmployeeNamePredicate},
//			{valid, validPredicate}
//		};
//	}
	
	@DataSupplier
	public Stream<AddUserScenarioType> getData(){
		FixtureFactoryLoader.loadTemplates("com.mfw.fixtures");
		return Stream.of(AddUserScenarioType.values());
	}
	

}
