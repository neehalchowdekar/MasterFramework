package com.mfw.fixtures.adduser.templates;

import com.mfw.fixtures.adduser.entity.UserData;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class AddUserTemplate implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(UserData.class).addTemplate("valid", new Rule(){{
			add("userRole", random("ESS", "Admin"));
			add("employeeName", random("Admin A", "Aaliyah haq"));
			add("userName", random("abcdef123"));
			add("status", random("Enabled", "Disabled"));
			add("password", random("Password@1234"));
			add("message", "Success message in the field is not displayed");
				}});
		
		Fixture.of(UserData.class).addTemplate("just_employeename", new Rule() {{
			add("employeeName", random("abcdef123"));
			add("message", "Error message in the field is not displayed");
		}});

	}
}
