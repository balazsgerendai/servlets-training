package com.epam.jjp.sjspt.domain;
/**
 * Creates a BlasterGun for Troopers to use as weapon
 * 
 *
 */
public class BlastGun extends Weapon{

	public BlastGun(final String name,final  int damage) {
		super(name, damage);
		
	}

	@Override
	public String hit(final Person person) {
		return "TyuuuuTyuuuuuTYUUUUTUYYUUUUUUU";
	}

	@Override
	public String toString() {
		return "BlastGun [getName()=" + getName() + ", getDamage()="
				+ getDamage() + "]";
	}

}
