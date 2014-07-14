package com.epam.jjp.sjspt.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Trooper extends Person {
	private static final String HIT_ENEMY_FOR_DAMAGE = "%s hit enemy %s for %d damage. Health remaining: %d";
	private Weapon weapon;
    private static Logger LOGGER = LoggerFactory.getLogger(Trooper.class);

	public Trooper(String name, Gender gender) {
		super(name, gender);
	}

	@Override
	public String fight(Person target) {
		String result = "";
		if(isDead() == false && target.isDead() == false){
			target.setHealth(target.getHealth() - weapon.getDamage());
			if(target.getHealth() <= 0) target.setDead(true);
			LOGGER.info( String.format(HIT_ENEMY_FOR_DAMAGE, this.getName(), target.getName(),weapon.getDamage(),target.getHealth()));
			result = ( String.format(HIT_ENEMY_FOR_DAMAGE+"<br>", this.getName(), target.getName(),weapon.getDamage(),target.getHealth()));
		}
		return result;
	}

	@Override
	public String toString() {
		return "Trooper [weapon=" + weapon + ", getWeapon()=" + getWeapon()
				+ ", getName()=" + getName() + ", getGender()=" + getGender()+ "]";
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	

}
