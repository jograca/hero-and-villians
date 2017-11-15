package com.lmig.gcf.hero_and_villians.methods;

public class LivingThing {

	protected String name; 
	protected int health; 
	
	public LivingThing(String name, int health) {
		this.name = name;
		this.health = health;
	}

/*	public boolean isAlive() {
		if (health > 0) {
			return true;
		}
		return false;
	}
*/
	public boolean isAlive() {
		return (health > 0);
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getName() {
		return name;
	}
	
}
