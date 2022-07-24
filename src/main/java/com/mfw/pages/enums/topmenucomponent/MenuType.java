package com.mfw.pages.enums.topmenucomponent;

public enum MenuType {
	
	ADMIN("Admin"),
	PIM("PIM"),
	LEAVE("Leave");
	
	private final String name;
	
	public String getName() {
		return name;
	}
	
	MenuType(String name){
		this.name = name;
	}

}
