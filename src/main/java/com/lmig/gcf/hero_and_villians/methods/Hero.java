package com.lmig.gcf.hero_and_villians.methods;

import java.util.Random;

public class Hero extends LivingThing {

	// Create a "secret identity" for a Hero
	// Configure it in your Constructor, as you want it as a property for a Hero
	// when you
	// create a Hero object
	// create a Private variable for this Class to have a secret identity

	private String secretIdentity;

	public Hero(String name, int health, String secretIdentity) {
		super(name, health);

		this.secretIdentity = secretIdentity;
	}

	public void attack(LivingThing lt) {

		int monsterDamage = getRandomNumberInRange(1, 10);
		int heroDamage = getRandomNumberInRange(1, 10);

		lt.setHealth(lt.getHealth() - monsterDamage);
		this.setHealth(this.getHealth() - heroDamage);

	}

	private int getRandomNumberInRange(int min, int max) {
		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}

	public String getSecretIdentity() {
		return secretIdentity;
	}

	public void setSecretIdentity(String secretIdentity) {
		this.secretIdentity = secretIdentity;
	}

}
