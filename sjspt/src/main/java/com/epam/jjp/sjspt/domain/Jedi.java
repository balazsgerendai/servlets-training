package com.epam.jjp.sjspt.domain;


/**
 * A jedi force user that extends the the forceUser super class
 * 
 *
 */
public class Jedi extends ForceUser{
	public Jedi(String name, final Gender gender){
		super(name,gender,Force.LIGHT);
	}
	
	@Override
	public String toString() {
		return "Jedi [name=" + getName() + ", lightSabre=" + getLightSabre() + "]";
	}

}
