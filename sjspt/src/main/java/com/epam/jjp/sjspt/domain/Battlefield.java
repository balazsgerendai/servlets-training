package com.epam.jjp.sjspt.domain;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Creates a Battlefield for the two sides to fight over
 *
 */
public class Battlefield {
	private static final String THE_BATTLE_OF_IS_OVER_THE_WINNER_IS = "The battle of %s is over. The winner is the %s";

	private final String name;

	private final Army[] armies;

	private boolean battleOver = false;
	private Army sithArmie;
	private Army republicArmie;
	private Random flipCoin;
	private static Logger LOGGER = LoggerFactory.getLogger(Battlefield.class);
	private StringBuilder builder;

	public Battlefield(final String name, final Army[] armies) {
		this.name = name;
		this.armies = armies;

		flipCoin = new Random();
		builder = new StringBuilder();
	}

	@Override
	public String toString() {
		return "Battlefield [name=" + name + ", armies=" + armies.toString()
				+ "]";
	}

	/**
	 * Sorts the armies depending which side they are on
	 */
	private void sortArmies() {
		for (Army army : armies) {
			if (army.getSide() == Side.EMPIRE) {
				sithArmie = army;
			} else if (army.getSide() == Side.REPUBLIC) {
				republicArmie = army;
			} else {
				throw new IllegalArgumentException(
						"There is no sitting on the fence. CHOOSE");
			}
		}
	}

	/**
	 * The battle starts! while there is no clear victor the battle continues.
	 * The attacking sequence is decided on luck. First the forceUsers attack
	 * the enemy team. Either the enemy forceAttackers or the defenders. The
	 * first side who losses its defenses losses the battle.
	 */
	public void doBattle() {

		sortArmies();
		while (!battleOver) {
			if (republicArmie.isDefeated()) {
				battleOver = true;
				LOGGER.info(String.format(THE_BATTLE_OF_IS_OVER_THE_WINNER_IS,
						name, "Sith Empire"));
				builder.append(String.format(
						THE_BATTLE_OF_IS_OVER_THE_WINNER_IS + "<br>", name,
						"Sith Empire"));

			} else if (sithArmie.isDefeated()) {
				battleOver = true;
				LOGGER.info(String.format(THE_BATTLE_OF_IS_OVER_THE_WINNER_IS,
						name, "Republic"));
				builder.append(String.format(
						THE_BATTLE_OF_IS_OVER_THE_WINNER_IS + "<br>", name,
						"Republic"));
			} else {

				if (flipCoin.nextBoolean()) {
					builder.append(sithArmie.forceAttack(republicArmie));
					builder.append(sithArmie.attack(republicArmie));
				} else {
					builder.append(republicArmie.forceAttack(sithArmie));
					builder.append(republicArmie.attack(sithArmie));
				}
			}
		}
	}

	public String getName() {
		return name;
	}

	public Army[] getArmies() {
		return armies;
	}

	public String getBattleReport() {
		return builder.toString();
	}

}
