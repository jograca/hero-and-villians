package com.lmig.gcf.hero_and_villians.methods;

public class Damsel extends LivingThing {

	private int fearFactor; 

	public Damsel(String name, int health, int fearFactor) {
		super(name, health);
		
		this.fearFactor = fearFactor;
	}
	
	public int getFearFactor() {
		return fearFactor;
	}	
	
}
