package com.epam.jjp.sjspt.domain;
/**
 * Creates a lightsabre for forceUsers to use
 * @author Balazs
 *
 */
public class LightSabre extends Weapon{

	public LightSabre(final String name, final int damage){
		super(name, damage);
	}
	
	@Override
	public String hit(final Person person){
		return "ZzzzzzzZZzzzzzzzzzzzZZ";
	}
	@Override
	public String toString() {
		return "Lightsabre " + getName() +" " + getDamage() +", "+ System.identityHashCode(this);
	}

}
