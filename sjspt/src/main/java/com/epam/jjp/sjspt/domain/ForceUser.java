package com.epam.jjp.sjspt.domain;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class ForceUser extends Person{
	private static final String HIT_ENEMY_FOR_DAMAGE = "%s hit enemy %s for %d damage. Health remaining: %d %n";
	private Force allegiance = Force.UNDECIDED;
	private  LightSabre lightSabre;
	private Random forceLuck;
    private static Logger LOGGER = LoggerFactory.getLogger(ForceUser.class);

	public LightSabre getLightSabre() {
		return lightSabre;
	}

	public ForceUser(String name, final Gender gender, LightSabre lightSabre){
		this(name,gender, Force.UNDECIDED);
		this.lightSabre = lightSabre;
	}

	public ForceUser(String name, final Gender gender, final Force allegiance){
		super(name,gender);
		this.allegiance = allegiance;
		forceLuck = new Random();
	}
	/** The force user fights an enemy target. If the enemy target is a Trooper(non force user) the force user gets a "force power" to
	 *  have a chance of an instant kill. Otherwise if its an another force user we hit him for a the amount of damage our lightsabre has
	 *  @param Person target
	 * 
	 */
	@Override
	public String fight(Person target) {
		
		String result = "";
		if(isDead() == false && target.isDead() == false){
			if(forceLuck.nextBoolean() == true && target instanceof Trooper) {
				target.setDead(true);
				LOGGER.info("The force granted me strenght against you " + target.getName());
				result =  "The force granted me strenght against you " + target.getName();
			}else{
				target.setHealth(target.getHealth() - lightSabre.getDamage());
				if(target.getHealth() <= 0) target.setDead(true);
				LOGGER.info(String.format(HIT_ENEMY_FOR_DAMAGE,this.getName(),target.getName(),lightSabre.getDamage(), target.getHealth())); 
				result = String.format(HIT_ENEMY_FOR_DAMAGE ,this.getName(),target.getName(),lightSabre.getDamage(), target.getHealth());  
			}
		}
		return result;
	}
	
	@Override
	public String toString() {
		return "Sith [name=" + getName() + ", lightSabre=" + lightSabre + "]";
	}
	/**
	 *  Returns the force user allegience: LIGHT, DARK, UNDECIEDED
	 */
	public Force getAllegience() {
		return allegiance;
	}
	
	public void setAllegience(final Force allegiance) {
		this.allegiance = allegiance;
	}
	
	public void setLightSabre(final LightSabre lightSabre){
		this.lightSabre = lightSabre;
	}
}
