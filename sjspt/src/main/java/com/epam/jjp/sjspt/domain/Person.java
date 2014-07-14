package com.epam.jjp.sjspt.domain;


public abstract class Person {
	private final String name;
	private final Gender gender;
	private int health = 100;
	private boolean isDead = false;
	public Person(String name, Gender gender){
		this.name = name;
		this.gender = gender;
	}

	public String getName() {
		return this.name;
	}
	public Gender getGender(){
		return gender;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	public abstract String fight(final Person target);
		

}
