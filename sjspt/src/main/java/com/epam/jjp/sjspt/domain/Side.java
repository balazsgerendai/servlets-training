package com.epam.jjp.sjspt.domain;

public enum Side {
	EMPIRE("Empire"),
	REPUBLIC("Republic");
	
	private String name;
	
	Side(final String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
