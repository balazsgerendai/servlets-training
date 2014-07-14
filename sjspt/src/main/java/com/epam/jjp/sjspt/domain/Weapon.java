package com.epam.jjp.sjspt.domain;

public abstract class Weapon {
	private String name;
	private final int damage;
	
	public Weapon(final String name, final int damage){
		this.name = name;
		this.damage = damage;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public abstract String hit(final Person person);
}
