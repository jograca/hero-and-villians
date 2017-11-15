package com.lmig.gcf.hero_and_villians.methods;

public class Monster extends LivingThing {

	private String classification;

	public Monster(String name, int health, String classification) {
		super(name, health);

		this.classification = classification;
	}
	
	public void attack(LivingThing lt) {
		lt.setHealth(0);
	}

	public String getClassification() {
		return classification;
	}

}
