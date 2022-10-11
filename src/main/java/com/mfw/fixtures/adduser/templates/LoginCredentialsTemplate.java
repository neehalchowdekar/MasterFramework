package com.mfw.fixtures.adduser.templates;

import com.mfw.fixtures.adduser.entity.LoginData;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class LoginCredentialsTemplate implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(LoginData.class).addTemplate("valid", new Rule() {
			{
				add("userName", "Admin");
				add("password", "admin123");
				add("message", "Success message in the field is not displayed");
			}
		});
		
		Fixture.of(LoginData.class).addTemplate("invalid", new Rule() {
			{
				add("userName", "Admin");
				add("password", "1234");
				add("message", "Invalid credentials");
			}
		});
		
		Fixture.of(LoginData.class).addTemplate("username_empty", new Rule() {
			{
				add("userName", "Admin");
				add("message", "Password cannot be empty");
			}
		});
		
		Fixture.of(LoginData.class).addTemplate("password_empty", new Rule() {
			{
				add("password", "1234");
				add("message", "Username cannot be empty");
			}
		});
		
	}

}
