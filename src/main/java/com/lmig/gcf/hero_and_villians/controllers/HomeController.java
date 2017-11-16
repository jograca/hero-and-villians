package com.lmig.gcf.hero_and_villians.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gcf.hero_and_villians.methods.Damsel;
import com.lmig.gcf.hero_and_villians.methods.Hero;
import com.lmig.gcf.hero_and_villians.methods.Monster;

@Controller
public class HomeController {

	private Monster ourMonster;
	private Hero ourHero;
	private Damsel ourDamsel;

	public HomeController() {
		ourMonster = new Monster("Steve", 100, "Vampire");
		ourHero = new Hero("Clark Kent", 100, "Superman");
		ourDamsel = new Damsel("Lois Lane", 100, 0);
	}

	@RequestMapping("/")
	public ModelAndView defaultPage() {

		ModelAndView mv = new ModelAndView();
		
		mv.addObject("monster", ourMonster);
		mv.addObject("hero", ourHero);
		mv.addObject("damsel", ourDamsel);
		mv.setViewName("index");

		return mv;
	}
	
	@RequestMapping("/attack")
	public ModelAndView attackPage() {
		
		ourHero.attack(ourMonster);

		ModelAndView mv = new ModelAndView();
		
		mv.addObject("monster", ourMonster);
		mv.addObject("hero", ourHero);
		mv.addObject("damsel", ourDamsel); 
		mv.addObject("isGameOver", this.isGameOver());
		mv.setViewName("index");

		return mv;
	}
	
	@RequestMapping("/death")
	public ModelAndView deathPage() {
		
		ourHero.deathFight(ourMonster);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("monster", ourMonster);
		mv.addObject("hero", ourHero);
		mv.addObject("damsel", ourDamsel); 
		mv.addObject("isGameOver", this.isGameOver());
		mv.setViewName("index");

		return mv;
	}
	
	@RequestMapping("/reset")
	public ModelAndView resetPage() {
		
		ourHero.setHealth(100);
		ourMonster.setHealth(100);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("monster", ourMonster);
		mv.addObject("hero", ourHero);
		mv.addObject("damsel", ourDamsel); 
		mv.addObject("isGameOver", this.isGameOver());
		mv.setViewName("index");

		return mv;
	}
	
	public boolean isGameOver() {
		return (!ourMonster.isAlive() || !ourHero.isAlive());
	}
	
}
