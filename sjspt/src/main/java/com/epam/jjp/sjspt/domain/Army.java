package com.epam.jjp.sjspt.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Army implements Comparable<Army> {
	private Person leader;
	private Side side;
	private Map<Operation, List<Person>> soldiers = new HashMap<Operation, List<Person>>();
	private Random randomPerson;
	
	public Army(Person leader, Map<Operation, List<Person>> soldiers, Side side) {
		this.leader = leader;
		this.side = side;
		this.soldiers.putAll(soldiers);
		randomPerson = new Random();
	}

	public Map<Operation, List<Person>> getSoldiers() {
		return (soldiers);
	}

	public Person getLeader() {
		return leader;
	}

	@Override
	public String toString() {
		return "Army [leader=" + leader + ", soldiers=" + soldiers.toString()
				+ "]";
	}

	public int getArmyStrength() {
		int armyStrenght = 0;
		for (List<Person> army : soldiers.values()) {
			armyStrenght += army.size();
		}
		return armyStrenght;
	}

	public Side getSide() {
		return side;
	}

	public Person getRandomAttacker() {
		List<Person> troopers = soldiers.get(Operation.OFFENCE);
		return troopers.get(randomPerson.nextInt(soldiers.size()));
	}

	public Person getRandomDefender() {
		List<Person> troopers = soldiers.get(Operation.DEFENCE);
		return troopers.get(randomPerson.nextInt(soldiers.size()));
	}

	public Person getRandomForceAttacker() {
		List<Person> forceUsers = soldiers.get(Operation.FORCEATTACK);
		return forceUsers.get(randomPerson.nextInt(forceUsers.size()));
	}

	public boolean isDefeated() {
		boolean defeated = true;
		for (Person soldier : soldiers.get(Operation.DEFENCE)) {
			if (soldier.isDead() == false) {
				defeated = false;
			}

		}
		return defeated;
	}

	public String attack(Army enemy) {
		Person attacker = getRandomAttacker();
		Person enemyDefender = enemy.getRandomDefender();
		return attacker.fight(enemyDefender);
	}

	public String forceAttack(Army enemy) {
		Person attacker = getRandomForceAttacker();
		Person enemyAttacker = enemy.getRandomForceAttacker();
		return attacker.fight(enemyAttacker);
	}

	public int compareTo(Army o) {
		return this.getArmyStrength() - o.getArmyStrength();
	}

	public void setDefeated(boolean isDefeated) {
	}

}
