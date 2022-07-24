package com.mfw.pages.enums.adduser;

import java.util.function.BiPredicate;

import com.mfw.fixtures.adduser.entity.UserData;
import com.mfw.fixtures.adduser.factory.AddUserPredicateFactory;
import com.mfw.pages.pagecomponents.adduserpage.AddUserComponent;
import br.com.six2six.fixturefactory.Fixture;
import lombok.Getter;

@Getter
public enum AddUserScenarioType {
	
	VALID(AddUserPredicateFactory.getPredicate("valid"), Fixture.from(UserData.class).gimme("valid")),
	JUST_EMPLOYEE_NAME(AddUserPredicateFactory.getPredicate("just_employeename")
			, Fixture.from(UserData.class).gimme("just_employeename"));
	
	private final BiPredicate<UserData, AddUserComponent> predicate;
	private final UserData userData;

	AddUserScenarioType(BiPredicate<UserData, AddUserComponent> predicate, UserData userData) {
		this.predicate = predicate;
		this.userData = userData;
	}

}
