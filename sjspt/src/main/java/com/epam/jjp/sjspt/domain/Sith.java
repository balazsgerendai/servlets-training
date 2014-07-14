package com.epam.jjp.sjspt.domain;



public class Sith extends ForceUser{
	public Sith(String name, final Gender gender){
		super(name,gender,Force.LIGHT);
	}
	
	@Override
	public String toString() {
		return "Sith [name=" + getName() + ", lightSabre=" + getLightSabre() + "]";
	}


}
