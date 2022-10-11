package com.mfw.pages.enums.loginuser;

import java.util.function.BiPredicate;

import com.mfw.fixtures.adduser.entity.LoginData;
import com.mfw.fixtures.adduser.factory.LoginUserPredicateFactory;
import com.mfw.pages.LoginPage;

import br.com.six2six.fixturefactory.Fixture;
import lombok.Getter;

@Getter
public enum LoginUserScenarioType {
	
	VALID(LoginUserPredicateFactory.getPredicate("valid"), 
			Fixture.from(LoginData.class).gimme("valid")),
	INVALID(LoginUserPredicateFactory.getPredicate("invalid"), 
			Fixture.from(LoginData.class).gimme("invalid")),
	USERNAME_EMPTY(LoginUserPredicateFactory.getPredicate("username_empty"), 
			Fixture.from(LoginData.class).gimme("username_empty")),
	PASSWORD_EMPTY(LoginUserPredicateFactory.getPredicate("password_empty"), 
			Fixture.from(LoginData.class).gimme("password_empty"));
	
	private final BiPredicate<LoginData, LoginPage> predicate;
	private final LoginData loginData;
	
	LoginUserScenarioType(BiPredicate<LoginData, com.mfw.pages.LoginPage> predicate, LoginData loginData) {
		this.predicate = predicate;
		this.loginData = loginData;
	}

}
